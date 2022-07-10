package com.smartphoneshop.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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

    @Column(name = "`created_Date`")
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date createdDate;

    @ManyToOne
    @JoinColumn(name = "cate_Id",nullable = false)
    @JsonIgnore
    private Category category;

    @Column(name = "amount",nullable = false)
    private short amount;

    @Column(name = "`status`",columnDefinition = "1")
    private short status;

//    @OneToMany(mappedBy = "product", fetch = FetchType.EAGER)
//    private List<ProductImage> productImages;

//    @OneToMany(mappedBy = "product")
//    @Cascade(value = {org.hibernate.annotations.CascadeType.REMOVE, org.hibernate.annotations.CascadeType.SAVE_UPDATE})
//    private List<ProductRate> productRate;

    @OneToMany(mappedBy = "product",fetch = FetchType.EAGER)
    @JsonBackReference
    private List<CartItem> cartItemList;

//    @OneToMany(mappedBy = "product",fetch = FetchType.LAZY)
//    @Cascade(value = {org.hibernate.annotations.CascadeType.REMOVE, org.hibernate.annotations.CascadeType.SAVE_UPDATE})
//    private List<OrderItem> orderItems;


}
