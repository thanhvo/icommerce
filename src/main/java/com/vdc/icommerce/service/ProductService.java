package com.vdc.icommerce.service;

import com.vdc.icommerce.model.Product;

public interface ProductService {
    Iterable<Product> getAllProducts(String keyword);

    Product getProduct(long id);

    Product save(Product product);
}
