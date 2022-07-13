package com.smartphoneshop.services.Impl;

import com.smartphoneshop.entity.CartItem;
import com.smartphoneshop.repositories.ICartItemRepository;
import com.smartphoneshop.services.ICartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartItemService implements ICartItemService {

    @Autowired
    private ICartItemRepository repository;


    @Override
    public CartItem createCartItem(CartItem cartItem) {
        repository.save(cartItem);
        return cartItem;
    }

    @Override
    public CartItem updateCartItemAmount(Integer id ,CartItem cartItem) {
        cartItem.setId(id);
        return repository.save(cartItem);
    }

    @Override
    public void updateCartItemAmount(Integer id, Integer Amount) {
        CartItem cartItem = repository.findCartItemById(id);
        cartItem.setAmount(Amount);
        repository.save(cartItem);
    }
}
