package com.vvt.icommerce.productservice.service;

import com.vvt.icommerce.productservice.model.Product;

public interface ProductService {
    Iterable<Product> getAllProducts(String keyword);

    Product getProduct(long id);

    Product save(Product product);
}
