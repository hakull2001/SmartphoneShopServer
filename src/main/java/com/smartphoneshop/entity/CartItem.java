package com.smartphoneshop.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@Entity
@Table(name = "cartItems")
public class CartItem implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "amount",nullable = false)
    private Integer amount;

    @ManyToOne
    @JoinColumn(name = "cart_Id")
    private Cart cart;


    @ManyToOne
    @JoinColumn(name = "product_Id")
    private Product product;

}
