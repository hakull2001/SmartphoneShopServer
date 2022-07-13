package com.smartphoneshop.services;

import com.smartphoneshop.entity.Cart;
import com.smartphoneshop.entity.CartItem;
import com.smartphoneshop.filter.AddCartParams;

public interface ICartItemService {

    CartItem createCartItem(CartItem cartItem);

    CartItem updateCartItemAmount(Integer id,CartItem cartItem);

    void updateCartItemAmount(Integer id,Integer Amount);

}
