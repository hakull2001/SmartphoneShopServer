package com.smartphoneshop.controllers;

import com.smartphoneshop.filter.AddCartParams;
import com.smartphoneshop.services.ICartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/cartitem")
@CrossOrigin("*")
public class CartItemController {

    @Autowired
    private ICartItemService service;

    @PutMapping(value = "/{id}/{Amount}")
    public ResponseEntity<?> updateAmountCartItems(@PathVariable("id") Integer id,
                                                   @PathVariable("Amount") Integer Amount){

        service.updateCartItemAmount(id , Amount);
        return new ResponseEntity<>("updated amount successful", HttpStatus.OK);
    }


}
