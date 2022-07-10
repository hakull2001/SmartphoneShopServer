package com.smartphoneshop.services;

import com.smartphoneshop.entity.Cart;
import com.smartphoneshop.entity.CartItem;

import java.util.List;

public interface ICartService {
    List<Cart> getAllCarts();

    Cart getCartByUserId(Integer userId);
}
