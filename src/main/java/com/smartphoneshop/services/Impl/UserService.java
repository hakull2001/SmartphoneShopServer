package com.smartphoneshop.services.Impl;

import com.smartphoneshop.entity.User;
import com.smartphoneshop.repositories.IUserRepository;
import com.smartphoneshop.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService implements IUserService {
    @Autowired
    private IUserRepository userRepository;

    @Override
    public List<User> getListUsers() {
        return userRepository.findAll();
    }
}
