package com.smartphoneshop.entity;

import com.smartphoneshop.entity.Enum.EStatus;
import com.smartphoneshop.entity.Key.OrderItemKey;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Data
public class OrderItem {

    @EmbeddedId
    OrderItemKey id;

    @Column(name = "createdDate")
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp //default now
    private Date createdDate;

    @Column(name = "receivedDate",columnDefinition = "null")
    @Temporal(TemporalType.DATE)
    private Date receivedDate;

    @Column(name = "`status`",columnDefinition = "Processing")
    @Enumerated(EnumType.STRING)
    private EStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "orderId")
    private Order order;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "productId")
    private Product product;
}
