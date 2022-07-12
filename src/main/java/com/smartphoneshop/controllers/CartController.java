package com.smartphoneshop.controllers;

import com.smartphoneshop.filter.AddCartParams;
import com.smartphoneshop.services.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
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


    @PostMapping
    public ResponseEntity<?> addCartItemToCart(@RequestBody AddCartParams params){
        service.addCartItemToCart(params);
        return new ResponseEntity<>("add to cart successful", HttpStatus.OK);
    }




}
