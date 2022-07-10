package com.smartphoneshop.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "categories")
public class Category implements Serializable {
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short id;

    @Column(name = "`name`",length = 255,nullable = false)
    private String name;

    @Column(name = "`status`",columnDefinition = "1")
    private short status;

    @OneToMany(mappedBy = "category", fetch = FetchType.EAGER)
    private List<Product> products;

}
