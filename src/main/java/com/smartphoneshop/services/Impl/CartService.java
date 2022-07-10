package com.smartphoneshop.services.Impl;

import com.smartphoneshop.entity.Cart;
import com.smartphoneshop.entity.CartItem;
import com.smartphoneshop.repositories.ICartItemRepository;
import com.smartphoneshop.repositories.ICartRepository;
import com.smartphoneshop.services.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService implements ICartService {
    @Autowired
    private ICartRepository cartRepository;

    @Autowired
    private ICartItemRepository cartItemRepository;

    @Override
    public List<Cart> getAllCarts() {
        return null;
    }

    @Override
    public Cart getCartByUserId(Integer userId) {
        return cartRepository.findByUserId(userId);
    }
}
