package com.smartphoneshop.repositories;

import com.smartphoneshop.entity.Cart;
import com.smartphoneshop.entity.Category;
import org.springframework.data.jpa.domain.JpaSort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ICartRepository extends JpaRepository<Cart, Integer> {

    Cart findCartByUserId(Integer id);



}
