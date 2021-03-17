package com.vdc.icommerce.repository;

import com.vdc.icommerce.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepositoy extends JpaRepository<Order, Long> { }
