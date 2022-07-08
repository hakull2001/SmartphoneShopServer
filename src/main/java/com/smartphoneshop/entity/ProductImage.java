package com.smartphoneshop.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
@Data
public class ProductImage implements Serializable {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  short id;

    @Column(name = "imageUrl",nullable = false)
    private String imageUrl;

    @Column(name = "createdAt")
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp //Deafault now
    private Date createdAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "productId",nullable = false)
    private short productId;

}
