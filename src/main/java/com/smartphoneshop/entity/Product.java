package com.smartphoneshop.entity;

import lombok.Data;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class Product implements Serializable {
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short id;

    @Column(name = "`title`",length = 255,nullable = false)
    private String title;

    @Column(name = "`descriptions`",length = 1000,nullable = false)
    private String descriptions;

    @Column(name = "originalPrice",nullable = false)
    private int originalPrice;

    @Column(name = "promotionPrice",nullable = false)
    private int promotionPrice;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author",nullable = false)
    private short author;

    @Column(name = "`createdDate`")
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date createdDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cateId",nullable = false)
    private short cateId;

    @Column(name = "amount",nullable = false)
    private short amount;

    @Column(name = "`status`",columnDefinition = "1")
    private short status;

    @OneToMany(mappedBy = "productId",fetch = FetchType.LAZY)
    @Cascade(value = {org.hibernate.annotations.CascadeType.REMOVE, org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    private List<ProductImage> productImages;

    @OneToOne(mappedBy = "productId",fetch = FetchType.LAZY)
    @Cascade(value = {org.hibernate.annotations.CascadeType.REMOVE, org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    private ProductRate productRate;

    @OneToMany(mappedBy = "productId",fetch = FetchType.LAZY)
    @Cascade(value = {org.hibernate.annotations.CascadeType.REMOVE, org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    private List<CartItem> cartItemList;

    @OneToMany(mappedBy = "productId",fetch = FetchType.LAZY)
    @Cascade(value = {org.hibernate.annotations.CascadeType.REMOVE, org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    private List<OrderItem> orderItems;


}
