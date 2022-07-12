package com.smartphoneshop.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.smartphoneshop.entity.Enum.ERole;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
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
    private Integer id;

    @Column(name = "username",length = 255,nullable = false, unique = true)
    private String userName;

    @Column(name = "email",length = 255,nullable = false, unique = true)
    private String email;

    @Column(name = "fullname",length = 255,nullable = false)
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

    @Column(name = "`status`")
    private short status;

    @Column(name = "avatar",nullable = false,length = 500)
    private String avatar;


    @OneToOne(mappedBy = "user")
    @JsonIgnore
    @Cascade(value = {org.hibernate.annotations.CascadeType.REMOVE, org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    private Cart cart;

    @OneToOne(mappedBy = "user")
    @JsonIgnore
    @Cascade(value = {org.hibernate.annotations.CascadeType.REMOVE, org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    private  Order  order;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    @Cascade(value = {org.hibernate.annotations.CascadeType.REMOVE, org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    private List<ProductRates> productRatesList;

}
