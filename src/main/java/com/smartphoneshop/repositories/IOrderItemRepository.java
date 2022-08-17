package com.smartphoneshop.repositories;

import com.smartphoneshop.constants.StatusOrderItem;
import com.smartphoneshop.entity.OrderItem;
import org.hibernate.criterion.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IOrderItemRepository extends JpaRepository<OrderItem,Integer> {

    @Query("select u from OrderItem u where u.status = ?1")
    List<OrderItem> findOrderItemsByStatusIs(StatusOrderItem statusOrderItem);

    @Query("select u from OrderItem u where u.status = 'Complete' and MONTH(u.createdDate) = ?1")
    List<OrderItem> findOrderItemsByReceivedDateAndStatus(int month);

    OrderItem findOrderItemById(Integer id);

    void deleteById(Integer id);

}
