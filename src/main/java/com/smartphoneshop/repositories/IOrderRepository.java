package com.smartphoneshop.repositories;

import com.smartphoneshop.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrderRepository extends JpaRepository<Order,Integer> {
}
