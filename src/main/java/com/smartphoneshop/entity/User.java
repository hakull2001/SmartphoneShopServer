package com.smartphoneshop.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.smartphoneshop.constants.RoleEnum;
import com.smartphoneshop.constants.StatusCodeEnum;
import lombok.Data;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Data
@Entity
@Table(name = "`users`")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(name = "fullname", nullable = false, unique = true)
    private  String fullName;

    @Column(nullable = false)
    private String password;

    @Column(name = "phone", nullable = false, unique = true)
    private String phoneNumber;

    @Column(nullable = false)
    private String address;

    @Column(name = "`role`")
    private String role;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "`status`", nullable = false)
    private StatusCodeEnum status;

    @Column(name = "avatar",nullable = false,length = 500)
    private String avatar;

    @OneToOne(mappedBy = "user")
    @JsonIgnore
    private Cart cart;

//    @OneToOne(mappedBy = "user")
//    @Cascade(value = {org.hibernate.annotations.CascadeType.REMOVE, org.hibernate.annotations.CascadeType.SAVE_UPDATE})
//    private  Order  order;

    @PrePersist
    public void prePersist() {
        if (this.role == null)
            this.role = RoleEnum.CLIENT;
        if(this.status == null)
            this.status = StatusCodeEnum.NOT_ACTIVE;
        this.password = new BCryptPasswordEncoder().encode(this.password);
    }
}
