package com.smartphoneshop.controllers;

import com.smartphoneshop.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/products")
@CrossOrigin("*")
public class ProductController {

    @Autowired
    private IProductService service;

    @GetMapping
    public ResponseEntity<?> getAllProducts(){
        return new ResponseEntity<>(service.getAllProducts() , HttpStatus.OK);
    }


}
