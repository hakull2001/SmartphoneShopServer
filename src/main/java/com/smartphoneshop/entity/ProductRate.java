package com.smartphoneshop.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
public class ProductRate  implements Serializable {
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short id;

    @OneToOne
    @JoinColumn(name = "userId",nullable = false)
    private short userId;

    @OneToOne
    @JoinColumn(name = "productId",nullable = false)
    private short productId;

    @Column(name = "`value`",nullable = false)
    private short value;

    @Column(name = "`comment`",length = 1000, nullable = false)
    private String comment;

    @Column(name = "createdAt")
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date createdAt;

    @Column(name = "updateAt")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateAt;

}
