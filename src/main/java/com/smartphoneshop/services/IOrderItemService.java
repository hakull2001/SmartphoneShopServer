package com.smartphoneshop.services;

import com.smartphoneshop.constants.StatusOrderItem;
import com.smartphoneshop.entity.OrderItem;
import com.smartphoneshop.entity.User;
import org.springframework.data.domain.Page;

import java.util.Date;
import java.util.List;

public interface IOrderItemService {

    List<OrderItem> getAllOrderItemsByStatus(StatusOrderItem status);

    OrderItem getOrderItemById(Integer id);

    Integer getMonthlyRevenue(int month);

    void createOrderItems(OrderItem orderItem);

    void updateOrderItemStatus(Integer id , StatusOrderItem status);

    void deleteById(Integer id);

}
