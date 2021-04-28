package com.vvt.icommerce.orderservice.service;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface OrderProducer {
    String ORDERS_OUT = "orders";

    @Output(ORDERS_OUT)
    MessageChannel orders();

}
