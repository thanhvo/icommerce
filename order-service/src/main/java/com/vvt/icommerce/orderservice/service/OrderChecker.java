package com.vvt.icommerce.orderservice.service;

import com.vvt.icommerce.orderservice.model.Order;
import com.vvt.icommerce.orderservice.model.OrderMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class OrderChecker {

    @Autowired
    private OrderConsumer orderConsumer;

    @StreamListener(OrderConsumer.ORDERS_IN)
    public void checkOrder(Order order) {
        log.info("Pulling order: {} for ${}", order.getStatus(), order.getId(), order.getTotalOrderPrice());
        OrderMessage orderMessage = new OrderMessage(order);
        orderConsumer.approved().send(orderMessage.getMessage());
        log.info("Publishing approved order: {} {} for ${}", order.getStatus(), order.getId(), order.getTotalOrderPrice());
    }
}