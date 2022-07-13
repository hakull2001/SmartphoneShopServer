package com.smartphoneshop.services;

import com.smartphoneshop.entity.OrderItem;

import java.util.List;

public interface IOrderItemService {
    public List<OrderItem> getAllOrderItemById(Integer id);
}
