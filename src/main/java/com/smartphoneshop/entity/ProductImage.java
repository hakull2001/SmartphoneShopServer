package com.smartphoneshop.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
@Data
@Entity
@NoArgsConstructor
@Table(name = "ProductImages")
public class ProductImage implements Serializable {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;

    @Column(name = "image_Url",nullable = false)
    private String imageUrl;

    @Column(name = "created_At")
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp //Deafault now
    private Date createdAt;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "product_Id")
    private Product product;

}
