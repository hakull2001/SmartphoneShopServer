package com.smartphoneshop.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.smartphoneshop.constants.StatusCodeProductEnum;
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

    @Column(name = "`status`",columnDefinition = "1")
    private StatusCodeProductEnum status;

    @ManyToOne
    @JoinColumn(name = "categoryId",nullable = false)
    @JsonBackReference
    private Category category;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<ProductImage> productImages;

    @OneToMany(mappedBy = "product")
    private List<ProductRate> productRatesList;

    @OneToMany(mappedBy = "product")
    @JsonIgnore
    private List<CartItem> cartItemList;

    @OneToMany(mappedBy = "product")
    @JsonIgnore
    @Cascade(value = {org.hibernate.annotations.CascadeType.REMOVE, org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    private List<OrderItem> orderItems;

    @PrePersist
    public void PrePersist(){
        if(this.status == null)
            this.status = StatusCodeProductEnum.OPENING;
    }
}
