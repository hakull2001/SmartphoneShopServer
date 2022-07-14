package com.smartphoneshop.services;

import com.smartphoneshop.entity.Cart;
import com.smartphoneshop.entity.CartItem;
import com.smartphoneshop.filter.AddCartParams;

import java.util.List;

public interface ICartItemService {

    CartItem getCartItemById(Integer id);

    CartItem createCartItem(CartItem cartItem);

    CartItem updateCartItemAmount(Integer id,CartItem cartItem);

    void updateCartItemAmount(Integer id,Integer Amount);

    void deleteById(Integer id);

    void deleteByIdIn(List<Integer> ids);


}
