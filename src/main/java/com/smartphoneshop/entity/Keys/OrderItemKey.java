package com.smartphoneshop.entity.Keys;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
public class OrderItemKey implements Serializable {
    @Column(name = "order_Id")
    Integer orderId;

    @Column(name = "product_Id")
    Integer productId;
}
