package com.smartphoneshop.controllers;

import com.smartphoneshop.constants.Common;
import com.smartphoneshop.services.ICartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        return new ResponseEntity<>(Common.MSG_UPDATED_AMOUNT_SUCCESS, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteCartItemById(@PathVariable("id") Integer id){
        service.deleteById(id);
        return new ResponseEntity<>(Common.MSG_DELETE_SUCCESS , HttpStatus.OK);
    }

    @DeleteMapping(value = "/list/{ids}")
    public ResponseEntity<?> deleteListCartItemsById(@PathVariable("ids") List<Integer> ids){
        service.deleteByIdIn(ids);
        return new ResponseEntity<>(Common.MSG_DELETE_SUCCESS , HttpStatus.OK);
    }


}
