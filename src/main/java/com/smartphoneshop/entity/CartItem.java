package com.smartphoneshop.entity;

import com.smartphoneshop.entity.Keys.CartItemKey;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "cartItems")
public class CartItem implements Serializable {
    @EmbeddedId
    CartItemKey id;

    @Column(name = "amount",nullable = false)
    private Integer amount;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("cartId")
    @JoinColumn(name = "cart_Id")
    private Cart cart;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("productId")
    @JoinColumn(name = "product_Id")
    private Product product;

}
