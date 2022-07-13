package com.smartphoneshop.services.Impl;

import com.smartphoneshop.entity.RegistrationUserToken;
import com.smartphoneshop.entity.User;
import com.smartphoneshop.repositories.IRegistrationUserTokenRepository;
import com.smartphoneshop.services.IRegistrationUserTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class RegistrationUserTokenService implements IRegistrationUserTokenService {
    @Autowired
    private IRegistrationUserTokenRepository registrationUserTokenRepository;

    @Override
    public void createNewRegistrationUserToken(User user, final String jwt) {

        RegistrationUserToken tokenEntity = new RegistrationUserToken(user, jwt);
        registrationUserTokenRepository.save(tokenEntity);
    }
}
