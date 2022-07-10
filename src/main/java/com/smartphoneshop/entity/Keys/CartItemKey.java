package com.smartphoneshop.entity.Keys;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;


@Embeddable
@Data
public class CartItemKey implements Serializable {

    @Column(name = "cart_Id")
    Integer cartId;

    @Column(name = "product_Id")
    Integer productId;
}
