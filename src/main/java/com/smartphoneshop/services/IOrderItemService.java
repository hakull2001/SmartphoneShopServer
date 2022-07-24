package com.smartphoneshop.services;

import com.smartphoneshop.constants.StatusOrderItem;
import com.smartphoneshop.entity.OrderItem;
import org.springframework.data.domain.Page;

import java.util.Date;
import java.util.List;

public interface IOrderItemService {

    List<OrderItem> getAllOrderItemsByStatus(StatusOrderItem status);

    Integer getMonthlyRevenue(int month);

    void createOrderItems(OrderItem orderItem);

    void updateOrderItemStatus(Integer id , StatusOrderItem status);
}
