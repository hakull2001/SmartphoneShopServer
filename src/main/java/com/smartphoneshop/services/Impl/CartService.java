package com.smartphoneshop.services.Impl;

import com.smartphoneshop.entity.Cart;
import com.smartphoneshop.entity.CartItem;
import com.smartphoneshop.entity.OrderItem;
import com.smartphoneshop.entity.Product;
import com.smartphoneshop.filter.AddCartParams;
import com.smartphoneshop.repositories.ICartRepository;
import com.smartphoneshop.services.ICartItemService;
import com.smartphoneshop.services.ICartService;
import com.smartphoneshop.services.IOrderItemService;
import com.smartphoneshop.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartService implements ICartService {

    @Autowired
    private ICartRepository repository;

    @Autowired
    private ICartItemService cartItemService;

    @Autowired
    private IProductService productService;

    @Autowired
    private IOrderItemService orderItemService;

    @Override
    public Cart getCartByUserId(Integer id) {
        return repository.findCartByUserId(id);
    }

    @Override
    public void addCartItemToCart(AddCartParams params) {
        Cart cart = repository.findCartByUserId(params.getUserId());
        Product product = productService.getProductById(params.getProductId());
        CartItem cartItem = null;
        for (CartItem item:cart.getCartItemList()) {
            if(item.getProduct().getId() == product.getId()){
                cartItem = item;
                break;
            }
        }
        if(cartItem != null){
            cartItem.setAmount(cartItem.getAmount() + params.getAmount());
            cartItemService.updateCartItemAmount(cartItem.getId(), cartItem);
        }
        else{
            cartItemService.createCartItem(new CartItem(params.getAmount() , cart , product));
        }
    }

    @Override
    public void buyCartItem(Integer userId , Integer cartItemId) {
        Cart cart = repository.findCartByUserId(userId);
        CartItem cartItem = cartItemService.getCartItemById(cartItemId);
        OrderItem orderItem = new OrderItem(cartItem.getAmount() ,cart.getUser().getOrder() , cartItem.getProduct());
        orderItemService.createOrderItems(orderItem);
        cartItemService.deleteById(cartItemId);
    }

    @Override
    public void buyListCartItems(Integer userId) {
        Cart cart = repository.findCartByUserId(userId);
        List<Integer> listId = new ArrayList<>();
        for (CartItem item: cart.getCartItemList()) {
            OrderItem orderItem = new OrderItem(item.getAmount() , item.getCart().getUser().getOrder() , item.getProduct());
            orderItemService.createOrderItems(orderItem);
            listId.add(item.getId());
        }
        cartItemService.deleteByIdIn(listId);
    }


}
