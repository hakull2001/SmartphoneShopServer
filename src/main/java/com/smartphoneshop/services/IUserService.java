package com.smartphoneshop.services;

import com.smartphoneshop.dto.SignUpDTO;
import com.smartphoneshop.dto.pagination.PaginateDTO;
import com.smartphoneshop.dto.update.UpdateUserDTO;
import com.smartphoneshop.entity.User;
import com.smartphoneshop.specifications.GenericSpecification;

import java.util.List;

public interface IUserService  {
    PaginateDTO<User> getList(Integer page, Integer perPage, GenericSpecification<User> specification);

    User findByEmail(String email);

    User findByUsername(String username);

    User create(SignUpDTO signUpDTO);

    void activeUser(String token);

    User updateUser(User user);

    void create(User user);

    User findById(Integer userId);

    User update(UpdateUserDTO updateUserDTO, User currentUser);

    void deleteById(Integer userId);
}
