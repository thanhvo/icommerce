package com.vvt.icommerce.productservice;

import com.vvt.icommerce.productservice.model.Product;
import com.vvt.icommerce.productservice.service.ProductService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class ProductServiceApplication {

	@Bean
	CommandLineRunner runner(ProductService productService) {
		return args -> {
			productService.save(new Product(1L, "TV Set", 300.00, "http://placehold.it/200x100", "SamSung", "black"));
			productService.save(new Product(2L, "Game Console", 200.00, "http://placehold.it/200x100", "MS", "black"));
			productService.save(new Product(3L, "Sofa", 100.00, "http://placehold.it/200x100", "IKEA", "brown"));
			productService.save(new Product(4L, "Icecream", 5.00, "http://placehold.it/200x100", "Walls", "pink"));
			productService.save(new Product(5L, "Beer", 3.00, "http://placehold.it/200x100", "Tiger", "brown"));
			productService.save(new Product(6L, "Phone", 500.00, "http://placehold.it/200x100", "Apple", "white"));
			productService.save(new Product(7L, "Watch", 30.00, "http://placehold.it/200x100", "Rolex", "black"));
			productService.save(new Product(8L, "Laptop", 2000.00, "http://placehold.it/200x100", "Apple", "white"));
			productService.save(new Product(9L, "Shirt", 30.00, "http://placehold.it/200x100", "Banana Republic", "red"));
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(ProductServiceApplication.class, args);
	}

}
