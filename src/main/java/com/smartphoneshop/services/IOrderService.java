package com.smartphoneshop.services;

import com.smartphoneshop.constants.StatusOrderItem;
import com.smartphoneshop.entity.Order;

import java.util.List;

public interface IOrderService {

    Order getOrderByUserId(Integer userId);

    Order updateOrderAmount(Integer amount , Order order);



}
