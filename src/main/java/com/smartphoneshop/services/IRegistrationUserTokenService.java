package com.smartphoneshop.services;

import com.smartphoneshop.entity.User;
import org.springframework.security.core.userdetails.UserDetails;

public interface IRegistrationUserTokenService {
    void createNewRegistrationUserToken(User user, final String jwt);
}
