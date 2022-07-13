package com.smartphoneshop.repositories;

import com.smartphoneshop.entity.ResetPasswordUserToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IResetPasswordUserTokenRepository extends JpaRepository<ResetPasswordUserToken, Integer> {
    void deleteByUserId(Integer userId);
}
