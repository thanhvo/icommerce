package com.vdc.icommerce;

import com.vdc.icommerce.model.Order;
import com.vdc.icommerce.model.OrderProduct;
import com.vdc.icommerce.model.Product;
import com.vdc.icommerce.service.OrderProductService;
import com.vdc.icommerce.service.OrderService;
import com.vdc.icommerce.service.ProductService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/** @author Thanh Vo **/
@SpringBootApplication
public class IcommerceApplication {

	@Bean
	CommandLineRunner runner(ProductService productService, OrderService orderService, OrderProductService orderProductService) {
		return args -> {
			Order order = orderService.create(new Order());
			Product p1 = new Product(1L, "TV Set", 300.00, "http://placehold.it/200x100", "SamSung", "black");
			productService.save(p1);
			OrderProduct orderProduct = new OrderProduct(order, p1, 1);
			orderProductService.create(orderProduct);
			productService.save(new Product(2L, "Game Console", 200.00, "http://placehold.it/200x100", "MS", "black"));
			productService.save(new Product(3L, "Sofa", 100.00, "http://placehold.it/200x100", "IKEA", "brown"));
			productService.save(new Product(4L, "Icecream", 5.00, "http://placehold.it/200x100", "Walls", "pink"));
			productService.save(new Product(5L, "Beer", 3.00, "http://placehold.it/200x100", "Tiger", "brown"));
			productService.save(new Product(6L, "Phone", 500.00, "http://placehold.it/200x100", "Apple", "white"));
			productService.save(new Product(7L, "Watch", 30.00, "http://placehold.it/200x100", "Rolex", "black"));
		};
	}
	public static void main(String[] args) {
		SpringApplication.run(IcommerceApplication.class, args);
	}

}
