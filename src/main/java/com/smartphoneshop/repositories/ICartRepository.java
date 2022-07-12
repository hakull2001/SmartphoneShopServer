package com.smartphoneshop.repositories;

import com.smartphoneshop.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICartRepository extends JpaRepository<Cart, Integer> {

    Cart findCartByUserId(Integer id);

}
