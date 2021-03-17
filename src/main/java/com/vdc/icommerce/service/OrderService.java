package com.vdc.icommerce.service;

import com.vdc.icommerce.model.Order;

public interface OrderService {
    Iterable<Order> getAllOrders();

    Order create(Order order);

    void update(Order order);
}
