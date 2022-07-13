package com.smartphoneshop.services;

import com.smartphoneshop.dto.SignUpDTO;
import com.smartphoneshop.dto.UserUpdateDTO;
import com.smartphoneshop.entity.User;

import java.util.List;

public interface IUserService  {
    List<User> getListUsers();

    User findByEmail(String email);

    User findByUsername(String username);

    User create(SignUpDTO signUpDTO);

    void activeUser(String token);

    User updateUser(UserUpdateDTO userUpdateDTO, User currentUser);

    User updateUser(User user);
}
