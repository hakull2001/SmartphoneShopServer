package com.smartphoneshop.entity;

import com.smartphoneshop.entity.Enum.EStatus;
import com.smartphoneshop.entity.Keys.OrderItemKey;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "orderItems")
public class OrderItem {
    @EmbeddedId
    OrderItemKey id;

    @Column(name = "created_Date")
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp //default now
    private Date createdDate;

    @Column(name = "received_Date",columnDefinition = "null")
    @Temporal(TemporalType.DATE)
    private Date receivedDate;

    @Column(name = "`status`",columnDefinition = "Processing")
    @Enumerated(EnumType.STRING)
    private EStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("orderId")
    @JoinColumn(name = "order_Id")
    private Order order;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("productId")
    @JoinColumn(name = "product_Id")
    private Product product;
}
