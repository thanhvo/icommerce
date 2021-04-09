package com.vvt.icommerce.productservice.controller;

import com.vvt.icommerce.productservice.dto.ProductDto;
import com.vvt.icommerce.productservice.model.Product;
import com.vvt.icommerce.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping(value = {"/{id}"})
    public Product getProduct(@PathVariable Long id) {
        return productService.getProduct(id);
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
