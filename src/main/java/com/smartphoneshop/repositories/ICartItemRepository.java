package com.smartphoneshop.repositories;

import com.smartphoneshop.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICartItemRepository extends JpaRepository<CartItem, Integer> {
    CartItem findCartItemsById(Integer id);
}
