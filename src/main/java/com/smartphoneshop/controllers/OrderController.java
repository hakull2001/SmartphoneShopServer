package com.smartphoneshop.controllers;

import com.smartphoneshop.services.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/orders")
@CrossOrigin("*")
public class OrderController {
    @Autowired
    private IOrderService service;

    @GetMapping(value = "/{userId}")
    public ResponseEntity<?> getOrderByUserId(@PathVariable("userId") Integer userId){
        return  new ResponseEntity<>(service.getOrderByUserId(userId) , HttpStatus.OK);
    }
}
