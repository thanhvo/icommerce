package com.vdc.icommerce.controller;

import com.vdc.icommerce.dto.ProductDto;
import com.vdc.icommerce.model.Product;
import com.vdc.icommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping(value = { "", "/" })
    public @NotNull Iterable<Product> getProducts(@RequestParam(required = false) String keyword) {
        return productService.getAllProducts(keyword);
    }

    @PostMapping
    public ResponseEntity<Product> updateProduct(@RequestBody ProductDto productDto){
        Product product = productService.getProduct(productDto.getId());
        product.setPrice(productDto.getPrice());
        productService.save(product);

        String uri = ServletUriComponentsBuilder
                .fromCurrentServletMapping()
                .path("/products/{id}")
                .buildAndExpand(product.getId())
                .toString();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", uri);

        return new ResponseEntity(product, headers, HttpStatus.OK);
    }
}
