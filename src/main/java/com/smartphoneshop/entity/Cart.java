package com.smartphoneshop.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonIgnore
    private User user;

    @OneToMany(mappedBy = "cart",fetch = FetchType.EAGER)
    private List<CartItem> cartItemList;


}
