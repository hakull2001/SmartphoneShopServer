package com.smartphoneshop.entity;

import com.smartphoneshop.entity.Enum.ERole;
import lombok.Data;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Data
@Table(name = "users",catalog = "smartPhoneShop")
public class User implements Serializable {
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short id;

    @Column(name = "username",length = 255,nullable = false, unique = true)
    private String userName;

    @Column(name = "email",length = 255,nullable = false, unique = true)
    private String email;

    @Column(name = "fullName",length = 255,nullable = false)
    private  String fullName;

    @Column(name = "`password`",length = 255,nullable = false)
    private String passWord;

    @Column(name = "phone",length = 15,nullable = false, unique = true)
    private String phoneNumber;

    @Column(name = "address",length = 500,nullable = false)
    private String address;

    @Column(name = "`role`",columnDefinition = "Client")
    @Enumerated(EnumType.STRING)
    private ERole role;

    @Column(name = "isConfirmed",columnDefinition = "0")
    private short isConfirmed;

    @Column(name = "avatarUrl",length = 500)
    private String avatarUrl;

    @OneToMany(mappedBy = "author")
    @Cascade(value = {org.hibernate.annotations.CascadeType.REMOVE, org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    private List<Product> products;

    @OneToOne(mappedBy = "userId")
    @Cascade(value = {org.hibernate.annotations.CascadeType.REMOVE, org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    private Cart cart;

    @OneToOne(mappedBy = "userId")
    @Cascade(value = {org.hibernate.annotations.CascadeType.REMOVE, org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    private  Order  order;

    @OneToOne(mappedBy = "userId")
    @Cascade(value = {org.hibernate.annotations.CascadeType.REMOVE, org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    private ProductRate productRate;

}
