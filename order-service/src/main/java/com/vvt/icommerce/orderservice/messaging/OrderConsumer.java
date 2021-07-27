package com.vvt.icommerce.orderservice.messaging;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface OrderConsumer {

    String ORDERS_IN = "orders";
    String APPROVED_OUT = "approved_orders";

    @Input(ORDERS_IN)
    SubscribableChannel sourceOfOrders();

    @Output(APPROVED_OUT)
    MessageChannel approved();

}

