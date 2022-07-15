package com.smartphoneshop.services;

import com.smartphoneshop.dto.pagination.PaginateDTO;
import com.smartphoneshop.entity.Cart;
import com.smartphoneshop.entity.CartItem;
import com.smartphoneshop.entity.Category;
import com.smartphoneshop.entity.Product;
import com.smartphoneshop.filter.AddCartParams;

public interface ICartService {
    Cart getCartByUserId(Integer id);

    void addCartItemToCart(AddCartParams params);

    void buyCartItem(Integer userId , Integer cartItemId);

    void buyListCartItems(Integer userId);



}
