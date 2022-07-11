package com.smartphoneshop.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Data
@Entity
@NoArgsConstructor
@Table(name = "`users`")
public class User implements Serializable {
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short id;

    @Column(name = "username",length = 255,nullable = false, unique = true)
    private String userName;

    @Column(name = "email",length = 255,nullable = false, unique = true)
    private String email;

    @Column(name = "fullname",length = 255,nullable = false)
    private  String fullName;

    @Column(name = "`password`",length = 255,nullable = false)
    private String password;

    @Column(name = "phone",length = 15,nullable = false, unique = true)
    private String phoneNumber;

    @Column(name = "address",length = 500,nullable = false)
    private String address;

    @Column(name = "`role`")
    private String role;

    @Column(name = "`status`")
    private short status;

    @Column(name = "avatar",nullable = false,length = 500)
    private String avatar;


//
//    @OneToOne(mappedBy = "user")
//    @Cascade(value = {org.hibernate.annotations.CascadeType.REMOVE, org.hibernate.annotations.CascadeType.SAVE_UPDATE})
//    private Cart cart;
//
//    @OneToOne(mappedBy = "user")
//    @Cascade(value = {org.hibernate.annotations.CascadeType.REMOVE, org.hibernate.annotations.CascadeType.SAVE_UPDATE})
//    private  Order  order;
//
    @OneToMany(mappedBy = "user")
    @Cascade(value = {org.hibernate.annotations.CascadeType.REMOVE, org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    private List<ProductRates> productRate;

    @OneToOne(mappedBy = "user")
    @JsonIgnore
    @Cascade(value = {org.hibernate.annotations.CascadeType.REMOVE, org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    private Cart cart;

    @OneToOne(mappedBy = "user")
    @JsonIgnore
    private  Order  order;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    @Cascade(value = {org.hibernate.annotations.CascadeType.REMOVE, org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    private List<ProductRates> productRatesList;

//    @PrePersist
//    public void PrePersist(){
//        this.password = new BCryptPasswordEncoder().encode(this.password);
//    }
}
