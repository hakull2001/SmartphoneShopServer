package com.smartphoneshop.controllers;

import com.smartphoneshop.services.IOderService;
import com.smartphoneshop.services.Impl.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/orders")
@CrossOrigin("*")
public class OrderController {
    @Autowired
    private IOderService iOderService;
    @GetMapping
    public ResponseEntity<?> getAllOrders(){
        return new ResponseEntity<>(iOderService.getAllOrder(), HttpStatus.OK);
    }
}
