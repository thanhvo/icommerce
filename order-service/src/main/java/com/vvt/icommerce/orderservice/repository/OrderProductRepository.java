package com.vvt.icommerce.orderservice.repository;

import com.vvt.icommerce.orderservice.model.OrderProduct;
import com.vvt.icommerce.orderservice.model.OrderProductPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderProductRepository extends JpaRepository<OrderProduct, OrderProductPK> {
}
