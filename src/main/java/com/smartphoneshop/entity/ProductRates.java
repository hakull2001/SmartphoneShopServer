package com.smartphoneshop.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "`PRODUCT_RATES`" )
public class ProductRates implements Serializable {
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short id;

    @ManyToOne
    @JoinColumn(name = "user_Id",nullable = false)
    private User user;

    @OneToOne
    @JoinColumn(name = "product_Id",nullable = false)
    private Product product;

    @Column(name = "`value`",nullable = false)
    private short value;

    @Column(name = "`comment`",length = 1000, nullable = false)
    private String comment;

    @Column(name = "created_At")
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date createdAt;

    @Column(name = "update_At")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateAt;

}
