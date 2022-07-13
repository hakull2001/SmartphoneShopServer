package com.smartphoneshop.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
    @JsonBackReference
    @JoinColumn(name = "cart_Id")
    private Cart cart;


    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "product_Id")
    private Product product;

}
