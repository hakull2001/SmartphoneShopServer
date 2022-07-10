package com.smartphoneshop.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
@Data
@Entity
@Table(name = "ProductImages")
public class ProductImage implements Serializable {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  short id;

    @Column(name = "image_Url",nullable = false)
    private String imageUrl;

    @Column(name = "created_At")
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp //Deafault now
    private Date createdAt;

    @ManyToOne
    @JoinColumn(name = "product_Id",nullable = false)
    @JsonIgnore
    private Product product;

}
