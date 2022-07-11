package com.smartphoneshop.services.Impl;


import com.smartphoneshop.entity.Order;
import com.smartphoneshop.repositories.IOrderRepository;
import com.smartphoneshop.services.IOderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderService implements IOderService {
    @Autowired
    private IOrderRepository iOrderRepository;

    @Override
    public List<Order> getAllOrder() {
        return iOrderRepository.findAll();
    }
}
