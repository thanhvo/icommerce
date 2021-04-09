package com.vvt.icommerce.orderservice.service;

import com.vvt.icommerce.orderservice.dto.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="product-service", url="localhost:8000")
//@FeignClient(name="currency-exchange-service")
//@FeignClient(name="netflix-zuul-api-gateway-server")
//@RibbonClient(name="currency-exchange-service")
public interface ProductServiceProxy {
    @GetMapping("/api/products")
    public List<Product> getAllProducts();

    @GetMapping("/api/products/{id}")
    public Product getProduct(@PathVariable("id") Long id);

}


