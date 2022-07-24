package com.smartphoneshop.services.Impl;


import com.smartphoneshop.constants.StatusOrderItem;
import com.smartphoneshop.entity.Order;
import com.smartphoneshop.repositories.IOrderRepository;
import com.smartphoneshop.services.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderService implements IOrderService {

    @Autowired
    private IOrderRepository repository;


    @Override
    public Order getOrderByUserId(Integer userId) {
        return repository.findOrderByUserId(userId);
    }

    @Override
    public Order updateOrderAmount(Integer amount, Order order) {
        order.setAmount(amount);
        repository.save(order);
        return order;
    }


}
