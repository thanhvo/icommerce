package com.vvt.icommerce.orderservice.repository;

import com.vvt.icommerce.orderservice.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> { }
