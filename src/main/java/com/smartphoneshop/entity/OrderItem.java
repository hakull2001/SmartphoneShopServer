package com.smartphoneshop.entity;

import com.smartphoneshop.entity.Enum.EStatus;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "orderItems")
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


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

//    @ManyToOne
//    @JoinColumn(name = "order_Id")
//    private Order order;
//
//    @ManyToOne
//    @JoinColumn(name = "product_Id")
//    private Product product;
}
