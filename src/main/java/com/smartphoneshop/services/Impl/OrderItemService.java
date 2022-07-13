package com.smartphoneshop.services.Impl;

import com.smartphoneshop.entity.OrderItem;
import com.smartphoneshop.repositories.IOrderItemRepository;
import com.smartphoneshop.services.IOrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderItemService implements IOrderItemService {
    @Autowired
    private IOrderItemRepository iOrderItemRepository;


    @Override
    public List<OrderItem> getAllOrderItemById(Integer id) {
        return iOrderItemRepository.findAll();
    }
}
