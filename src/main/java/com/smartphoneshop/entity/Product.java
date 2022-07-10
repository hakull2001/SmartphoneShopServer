package com.smartphoneshop.entity;

import lombok.Data;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "products")
public class Product implements Serializable {
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short id;

    @Column(name = "`title`",length = 255,nullable = false)
    private String title;

    @Column(name = "`descriptions`",length = 1000,nullable = false)
    private String descriptions;

    @Column(name = "original_Price",nullable = false)
    private int originalPrice;

    @Column(name = "promotion_Price",nullable = false)
    private int promotionPrice;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author",nullable = false)
    private User author;

    @Column(name = "`created_Date`")
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date createdDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cate_Id",nullable = false)
    private Category category;

    @Column(name = "amount",nullable = false)
    private short amount;

    @Column(name = "`status`",columnDefinition = "1")
    private short status;

    @OneToMany(mappedBy = "product",fetch = FetchType.LAZY)
    @Cascade(value = {org.hibernate.annotations.CascadeType.REMOVE, org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    private List<ProductImage> productImages;

    @OneToOne(mappedBy = "product",fetch = FetchType.LAZY)
    @Cascade(value = {org.hibernate.annotations.CascadeType.REMOVE, org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    private ProductRates productRate;

    @OneToMany(mappedBy = "product",fetch = FetchType.LAZY)
    @Cascade(value = {org.hibernate.annotations.CascadeType.REMOVE, org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    private List<CartItem> cartItemList;

    @OneToMany(mappedBy = "product",fetch = FetchType.LAZY)
    @Cascade(value = {org.hibernate.annotations.CascadeType.REMOVE, org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    private List<OrderItem> orderItems;


}
