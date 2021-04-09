package com.vvt.icommerce.orderservice.service;

import com.vvt.icommerce.orderservice.model.Order;

import java.util.Optional;

public interface OrderService {
    Iterable<Order> getAllOrders();

    Optional<Order> getOrder(Long id);

    Order create(Order order);

    void update(Order order);
}
