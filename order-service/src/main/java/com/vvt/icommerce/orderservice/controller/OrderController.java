package com.vvt.icommerce.orderservice.controller;

import com.vvt.icommerce.orderservice.dto.OrderForm;
import com.vvt.icommerce.orderservice.dto.OrderProductDto;
import com.vvt.icommerce.orderservice.exception.ResourceNotFoundException;
import com.vvt.icommerce.orderservice.model.Order;
import com.vvt.icommerce.orderservice.model.OrderProduct;
import com.vvt.icommerce.orderservice.service.OrderProductService;
import com.vvt.icommerce.orderservice.service.OrderService;
import com.vvt.icommerce.orderservice.service.ProductServiceProxy;
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
    private OrderService orderService;

    @Autowired
    private ProductServiceProxy productService;

    @Autowired
    private OrderProductService orderProductService;

    @GetMapping(value = { "", "/" })
    public @NotNull Iterable<Order> getOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping(value = {"/{id}" })
    public Order getOrder(@PathVariable Long id) {
        return orderService.getOrder(id).get();
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
            var product = productService.getProduct(dto.getProduct().getId());
            var orderProduct = new OrderProduct(order,
                    dto.getProduct().getId(),
                    dto.getQuantity()
            );
            orderProduct.setTotalPrice(product.getPrice() * dto.getQuantity());
            orderProducts.add(orderProductService.create(orderProduct));
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
