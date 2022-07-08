package com.smartphoneshop.entity.Key;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;


@Embeddable
@Data
public class CartItemKey {

    @Column(name = "cartId")
    Integer cartId;

    @Column(name = "productId")
    Integer productId;
}
