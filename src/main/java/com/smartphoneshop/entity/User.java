package com.smartphoneshop.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    @OneToMany(mappedBy = "user")
    @JsonBackReference
    private List<ProductRates> productRate;

    @OneToOne(mappedBy = "user")
    @JsonBackReference
    private Cart cart;

    @OneToOne(mappedBy = "user")
    @JsonBackReference
    private  Order  order;

//    @PrePersist
//    public void PrePersist(){
//        this.password = new BCryptPasswordEncoder().encode(this.password);
//    }
}
