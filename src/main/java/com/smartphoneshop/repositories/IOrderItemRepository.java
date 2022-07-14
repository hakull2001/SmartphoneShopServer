package com.smartphoneshop.repositories;

import com.smartphoneshop.constants.StatusOrderItem;
import com.smartphoneshop.entity.Order;
import com.smartphoneshop.entity.OrderItem;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IOrderItemRepository extends JpaRepository<OrderItem,Integer> {

    @Query("select u from OrderItem u where u.status = ?1")
    List<OrderItem> findOrderItemsByStatusIs(StatusOrderItem statusOrderItem);

    OrderItem findOrderItemById(Integer id);
}
