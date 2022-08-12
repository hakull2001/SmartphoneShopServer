package com.smartphoneshop.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.smartphoneshop.constants.StatusCodeProductEnum;
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
    private Integer id;

    @OneToOne
    @JoinColumn(name = "user_Id",nullable = false)
    @JsonManagedReference
    private User user;

    @Column(name = "amount")
    private Integer amount;


    @OneToMany(mappedBy = "cart")
    private List<CartItem> cartItemList;


    @PrePersist
    public void PrePersist(){
        this.amount = this.cartItemList.size();
    }

}
