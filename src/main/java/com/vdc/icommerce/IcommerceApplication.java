package com.vdc.icommerce;

import com.vdc.icommerce.model.Product;
import com.vdc.icommerce.service.ProductService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/** @author Thanh Vo **/
@SpringBootApplication
public class IcommerceApplication {

	@Bean
	CommandLineRunner runner(ProductService productService) {
		return args -> {
			productService.save(new Product(1,"Shoe", 1.0, "Nike", "White"));
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(IcommerceApplication.class, args);
	}

}
