package com.smartphoneshop.controllers;

import com.smartphoneshop.services.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1/cartItems")
@RestController
public class CartItemController {

    @Autowired
    private ICartService cartService;

    @GetMapping
    public ResponseEntity<?> getListCartItems(){
        return new ResponseEntity<>(cartService.getAllCarts(), HttpStatus.OK);
    }
}
