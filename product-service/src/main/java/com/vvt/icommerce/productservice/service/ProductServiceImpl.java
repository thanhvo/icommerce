package com.vvt.icommerce.productservice.service;

import com.vvt.icommerce.productservice.exception.ResourceNotFoundException;
import com.vvt.icommerce.productservice.model.Product;
import com.vvt.icommerce.productservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    // productRepository constructor injection
    @Autowired
    private ProductRepository productRepository;

    @Override
    public Iterable<Product> getAllProducts(String keyword) {
        if (keyword != null) {
            return productRepository.search(keyword);
        }
        return productRepository.findAll();
    }

    @Override
    public Product getProduct(long id) {
        return productRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found"));
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }
}
