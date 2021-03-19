package com.vdc.icommerce.controller;

import com.vdc.icommerce.dto.OrderProductDto;
import com.vdc.icommerce.exception.ResourceNotFoundException;
import com.vdc.icommerce.form.OrderForm;
import com.vdc.icommerce.model.Order;
import com.vdc.icommerce.model.OrderProduct;
import com.vdc.icommerce.model.Product;
import com.vdc.icommerce.service.OrderProductService;
import com.vdc.icommerce.service.OrderService;
import com.vdc.icommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    @Autowired
    OrderService orderService;

    @Autowired
    ProductService productService;

    @Autowired
    OrderProductService orderProductService;

    @GetMapping(value = { "", "/" })
    public @NotNull Iterable<Order> getOrders() {
        return orderService.getAllOrders();
    }

    @PostMapping
    public ResponseEntity<Order> create(@RequestBody OrderForm form) {
        List<OrderProductDto> formDtos = form.getProductOrders();
        validateProductsExistence(formDtos);
        Order order = new Order();
        //order.setStatus(OrderStatus.PAID.name());
        order = this.orderService.create(order);

        List<OrderProduct> orderProducts = new ArrayList<OrderProduct>();
        for (OrderProductDto dto : formDtos) {
            orderProducts.add(orderProductService.create(new OrderProduct(order, productService.getProduct(dto
                    .getProduct()
                    .getId()), dto.getQuantity())));
        }

        order.setOrderProducts(orderProducts);
        this.orderService.update(order);

        String uri = ServletUriComponentsBuilder
                .fromCurrentServletMapping()
                .path("/orders/{id}")
                .buildAndExpand(order.getId())
                .toString();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", uri);

        return new ResponseEntity<>(order, headers, HttpStatus.CREATED);
    }

    private void validateProductsExistence(List<OrderProductDto> orderProducts) {
        List<OrderProductDto> list = orderProducts
                .stream()
                .filter(op -> Objects.isNull(productService.getProduct(op
                        .getProduct()
                        .getId())))
                .collect(Collectors.toList());

        if (!CollectionUtils.isEmpty(list)) {
            new ResourceNotFoundException("Product not found");
        }
    }
}
