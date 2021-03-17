package com.vdc.icommerce.repository;

import com.vdc.icommerce.model.OrderProduct;
import com.vdc.icommerce.model.OrderProductPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderProductRepository extends JpaRepository<OrderProduct, OrderProductPK> {
}
