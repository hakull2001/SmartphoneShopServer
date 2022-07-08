package com.smartphoneshop.entity;

import com.smartphoneshop.entity.Enum.EStatus;
import lombok.Data;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class Order implements Serializable {
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short id;

    @OneToOne
    @JoinColumn(name = "userId",nullable = false)
    private  short userId;

    @OneToMany(mappedBy = "productId")
    @Cascade(value = {org.hibernate.annotations.CascadeType.REMOVE, org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    private List<OrderItem> orderItems;



}
