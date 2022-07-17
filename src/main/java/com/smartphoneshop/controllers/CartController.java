package com.smartphoneshop.controllers;

import com.smartphoneshop.constants.Common;
import com.smartphoneshop.filters.AddCartParams;
import com.smartphoneshop.services.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/cart")
@CrossOrigin("*")
public class CartController {


    @Autowired
    private ICartService service;



    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getCartByUserId(@PathVariable("id") Integer id){
        return new ResponseEntity<>(service.getCartByUserId(id) , HttpStatus.OK);
    }


    @PostMapping(value = "/addCartItem")
    public ResponseEntity<?> addCartItemToCart(@RequestBody AddCartParams params){
        service.addCartItemToCart(params);
        return new ResponseEntity<>(Common.MSG_CREATED_SUCCESSFUL_201, HttpStatus.OK);
    }

    @PostMapping(value = "/buyCartItem")
    public ResponseEntity<?> buyCartItem(@Param("userId") Integer userId , @Param("cartItemId") Integer cartItemId ){
        service.buyCartItem(userId , cartItemId);
        return new ResponseEntity<>("Buy cart items successful", HttpStatus.OK);
    }

    @PostMapping(value = "/buyListCartItems/{userId}")
    public ResponseEntity<?> buyListCartItems(@PathVariable("userId") Integer userId){
        service.buyListCartItems(userId);
        return new ResponseEntity<>("Buy all cart items successful", HttpStatus.OK);
    }

}

