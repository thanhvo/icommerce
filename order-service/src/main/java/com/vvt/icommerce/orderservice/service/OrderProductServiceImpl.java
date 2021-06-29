package com.vvt.icommerce.orderservice.service;

import com.vvt.icommerce.orderservice.model.OrderProduct;
import com.vvt.icommerce.orderservice.repository.OrderProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class OrderProductServiceImpl implements OrderProductService {

    private OrderProductRepository orderProductRepository;

    public OrderProductServiceImpl(OrderProductRepository orderProductRepository) {
        this.orderProductRepository = orderProductRepository;
    }

    @Override
    public OrderProduct create(OrderProduct orderProduct) {
        var result =  this.orderProductRepository.save(orderProduct);
        result.setTotalPrice(orderProduct.getTotalPrice());
        result.setPk(orderProduct.getPk());
        return result;
    }
}
