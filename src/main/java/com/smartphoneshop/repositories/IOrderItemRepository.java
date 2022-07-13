package com.smartphoneshop.repositories;

import com.smartphoneshop.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrderItemRepository extends JpaRepository<OrderItem,Integer> {
}
