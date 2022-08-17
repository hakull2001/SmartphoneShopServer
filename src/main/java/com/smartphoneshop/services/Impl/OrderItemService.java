package com.smartphoneshop.services.Impl;

import com.smartphoneshop.constants.StatusOrderItem;
import com.smartphoneshop.entity.OrderItem;
import com.smartphoneshop.repositories.IOrderItemRepository;
import com.smartphoneshop.services.IOrderItemService;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
@Service
public class OrderItemService implements IOrderItemService {

    private static final DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

    @Autowired
    private IOrderItemRepository repository;


    @Override
    public List<OrderItem> getAllOrderItemsByStatus(StatusOrderItem status) {
        return repository.findOrderItemsByStatusIs(status);
    }

    @Override
    public OrderItem getOrderItemById(Integer id) {
        return repository.findOrderItemById(id);
    }

    @Override
    public Integer getMonthlyRevenue(int month) {
        List<OrderItem> orderItems = repository.findOrderItemsByReceivedDateAndStatus(month);
        Integer revenue = 0;
        for (OrderItem item:orderItems) {
            revenue += item.getProduct().getPromotionPrice() * item.getAmount();
        }
        return revenue;
    }

    @Override
    public void createOrderItems(OrderItem orderItem) {
        repository.save(orderItem);
    }

    @Override
    public void updateOrderItemStatus(Integer id, StatusOrderItem status) {
        OrderItem orderItem = repository.findOrderItemById(id);
        if(orderItem.getStatus() == StatusOrderItem.Processing && status == StatusOrderItem.Processed){
            orderItem.setStatus(StatusOrderItem.Processed);
        }else if(orderItem.getStatus() == StatusOrderItem.Processed && status == StatusOrderItem.Delivering){
            orderItem.setStatus(StatusOrderItem.Delivering);
            dateFormat.format(orderItem.getCreatedDate());
            Calendar c = Calendar.getInstance();
            c.setTime(orderItem.getCreatedDate());
            c.add(Calendar.DATE,3);
            Date currentDatePlusOne = c.getTime();
            dateFormat.format(currentDatePlusOne);
            orderItem.setReceivedDate(currentDatePlusOne);
        }else if(orderItem.getStatus() == StatusOrderItem.Delivering && status == StatusOrderItem.Complete){
            orderItem.setStatus(StatusOrderItem.Complete);
        }
        repository.save(orderItem);
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
