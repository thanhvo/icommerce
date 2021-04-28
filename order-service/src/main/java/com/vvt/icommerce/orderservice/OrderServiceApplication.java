package com.vvt.icommerce.orderservice;

import com.vvt.icommerce.orderservice.service.OrderConsumer;
import com.vvt.icommerce.orderservice.service.OrderProducer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.stream.annotation.EnableBinding;

@SpringBootApplication
@EnableFeignClients
//@EnableDiscoveryClient
@RibbonClient(name="order-service")
@EnableBinding({OrderConsumer.class, OrderProducer.class})
public class OrderServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderServiceApplication.class, args);
	}

}
