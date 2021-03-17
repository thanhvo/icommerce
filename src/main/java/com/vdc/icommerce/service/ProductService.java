package com.vdc.icommerce.service;

import com.vdc.icommerce.model.Product;

public interface ProductService {
    Iterable<Product> getAllProducts();

    Product getProduct(long id);

    Product save(Product product);
}
