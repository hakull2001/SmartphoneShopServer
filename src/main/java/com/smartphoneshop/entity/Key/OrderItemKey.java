package com.smartphoneshop.entity.Key;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@Data
public class OrderItemKey {
    @Column(name = "orderId")
    Integer orderId;

    @Column(name = "productId")
    Integer productId;
}
