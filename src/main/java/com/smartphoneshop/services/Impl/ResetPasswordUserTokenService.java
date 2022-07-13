package com.smartphoneshop.services.Impl;

import com.smartphoneshop.entity.ResetPasswordUserToken;
import com.smartphoneshop.repositories.IResetPasswordUserTokenRepository;
import com.smartphoneshop.services.IResetPasswordUserTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResetPasswordUserTokenService implements IResetPasswordUserTokenService {
    @Autowired
    private IResetPasswordUserTokenRepository resetPasswordUserTokenRepository;

    @Override
    public void deleteResetPasswordTokenByUserId(Integer userId) {
        resetPasswordUserTokenRepository.deleteByUserId(userId);
    }

    @Override
    public void createResetPasswordUserToken(ResetPasswordUserToken resetPasswordUserToken) {
        resetPasswordUserTokenRepository.save(resetPasswordUserToken);
    }

    @Override
    public void deleteById(Integer id) {
        resetPasswordUserTokenRepository.deleteById(id);
    }
}
