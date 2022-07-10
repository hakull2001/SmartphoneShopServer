package com.smartphoneshop.services;

import com.smartphoneshop.entity.CartItem;

import java.util.List;

public interface ICartItemService {
    List<CartItem> getList();
}
