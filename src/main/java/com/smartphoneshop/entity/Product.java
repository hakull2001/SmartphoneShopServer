package com.smartphoneshop.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.smartphoneshop.constants.StatusCodeEnum;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@Table(name = "products")
public class Product implements Serializable {
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "`title`",length = 255,nullable = false)
    private String title;

    @Column(name = "`descriptions`",length = 1000,nullable = false)
    private String descriptions;

    @Column(nullable = false)
    private Integer originalPrice;

    @Column(nullable = false)
    private Integer promotionPrice;

    @Column(name = "`created_Date`")
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date createdDate;

    @Column(name = "amount",nullable = false)
    private Integer amount;

    @Column(name = "`status`")
    private StatusCodeEnum status;

    @ManyToOne
    @JsonManagedReference
    @JoinColumn(name = "categoryId",nullable = false)
    private Category category;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<ProductImage> productImages;

    @OneToMany(mappedBy = "product", fetch = FetchType.EAGER)
    @JsonIgnore
    private List<ProductRates> productRatesList;

    @OneToMany(mappedBy = "product")
    @JsonManagedReference
    private List<CartItem> cartItemList;

    @OneToMany(mappedBy = "product")
    @JsonManagedReference
    @Cascade(value = {org.hibernate.annotations.CascadeType.REMOVE, org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    private List<OrderItem> orderItems;

    //Set thuoc tinh cho ban ghi truoc khi luu vao database
    @PrePersist
    public void PrePersist(){
        if(this.status == null)
            this.status = StatusCodeEnum.OPEN;
    }
}
