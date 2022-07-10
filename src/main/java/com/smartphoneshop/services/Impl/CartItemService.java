package com.smartphoneshop.services.Impl;

import com.smartphoneshop.entity.Cart;
import com.smartphoneshop.repositories.ICartRepository;
import com.smartphoneshop.services.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartItemService implements ICartService {
    @Autowired
    private ICartRepository cartRepository;
    @Override
    public List<Cart> getAllCarts() {
        return cartRepository.findAll();
    }

    @Override
    public Cart getCartByUserId(Integer userId) {
        return null;
    }
}
