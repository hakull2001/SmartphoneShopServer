package com.smartphoneshop.entity;

import lombok.Data;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "cart")
public class Cart implements Serializable {
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short id;

    @OneToOne
    @JoinColumn(name = "user_Id",nullable = false)
    private User user;

    @OneToMany(mappedBy = "cart",fetch = FetchType.LAZY)
    @Cascade(value = {org.hibernate.annotations.CascadeType.REMOVE, org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    private List<CartItem> cartItemList;


}
