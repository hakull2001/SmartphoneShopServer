package com.smartphoneshop.controllers;


import com.smartphoneshop.constants.StatusOrderItem;
import com.smartphoneshop.services.IOrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/orderitems")
@CrossOrigin("*")
public class OrderItemController {

    @Autowired
    private IOrderItemService service;

    @GetMapping
    public ResponseEntity<?> getOrderItemsByStatus(@Param("status") StatusOrderItem status){
        return new ResponseEntity<>(service.getAllOrderItemsByStatus(status) , HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> updateOrderItemStatus(@Param("id") Integer id , @Param("status") StatusOrderItem status){
        service.updateOrderItemStatus(id , status);
        return new ResponseEntity<>("updated successfull" , HttpStatus.OK);
    }


}
