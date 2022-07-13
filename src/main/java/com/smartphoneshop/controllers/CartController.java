package com.smartphoneshop.controllers;

import com.smartphoneshop.services.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/carts")
public class CartController {
    @Autowired
    private ICartService cartService;

    @GetMapping
    public ResponseEntity<?> getListCarts(){
        return new ResponseEntity<>(cartService.getAllCarts(), HttpStatus.OK);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<?> getCardByUserId(@PathVariable(name = "userId") Integer userId){
        return new ResponseEntity<>(cartService.getCartByUserId(userId), HttpStatus.OK);
    }
}
