package com.smartphoneshop.entity;

import com.smartphoneshop.entity.Key.CartItemKey;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data

public class CartItem implements Serializable {
    @EmbeddedId
    CartItemKey id;

    @Column(name = "amount",nullable = false)
    private Integer amount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cartId")
    private Cart cart;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "productId")
    private Product product;

}
