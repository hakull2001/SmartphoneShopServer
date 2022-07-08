package com.smartphoneshop.entity;

import lombok.Data;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Table(name = "categories",catalog = "smartPhoneShop")
public class Category implements Serializable {
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short id;

    @Column(name = "`name`",length = 255,nullable = false)
    private String name;

    @Column(name = "`status`",columnDefinition = "1")
    private short status;

    @OneToMany(mappedBy = "cateId")
    @Cascade(value = {org.hibernate.annotations.CascadeType.REMOVE, org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    private List<Product> products;

}
