package com.smartphoneshop.repositories;

import com.smartphoneshop.entity.RegistrationUserToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRegistrationUserTokenRepository extends JpaRepository<RegistrationUserToken, Integer> {

    RegistrationUserToken findByToken(String token);
}
