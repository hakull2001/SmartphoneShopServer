package com.smartphoneshop.repositories;

import com.smartphoneshop.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import org.springframework.transaction.annotation.Transactional;

public interface ICartRepository extends JpaRepository<Cart, Integer> {
    Cart findByUserId(Integer userId);
}
