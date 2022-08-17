package com.smartphoneshop.controllers;


import com.smartphoneshop.constants.Common;
import com.smartphoneshop.constants.StatusOrderItem;
import com.smartphoneshop.entity.OrderItem;
import com.smartphoneshop.services.IOrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

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

    @GetMapping("/{id}")
    public ResponseEntity getOrderItemById(@PathVariable("id") Integer id){
        return new ResponseEntity(service.getOrderItemById(id) , HttpStatus.OK);
    }


    @GetMapping(value = "/revenue")
    public ResponseEntity<?> getMonthlyRevenue(@Param("month") int month){
        return new ResponseEntity<>(service.getMonthlyRevenue(month) , HttpStatus.OK);
    }


    @PutMapping
    public ResponseEntity<?> updateOrderItemStatus(@Param("id") Integer id , @Param("status") StatusOrderItem status){
        service.updateOrderItemStatus(id , status);
        return new ResponseEntity<>(Common.MSG_SUCCESS, HttpStatus.OK);
    }

    @GetMapping("/userBuy/{id}")
    public ResponseEntity<?> getUserBuyOrderItem(@PathVariable("id") Integer id){
        OrderItem item = service.getOrderItemById(id);
        return new ResponseEntity<>(item.getOrder().getUser(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteOrderItemById(@PathVariable("id") Integer id){
        service.deleteById(id);
        return new ResponseEntity<>("Delete Success", HttpStatus.OK);
    }


}
