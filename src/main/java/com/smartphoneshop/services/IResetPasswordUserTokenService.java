package com.smartphoneshop.services;

import com.smartphoneshop.entity.ResetPasswordUserToken;

public interface IResetPasswordUserTokenService {
    void deleteResetPasswordTokenByUserId(Integer userId);

    void createResetPasswordUserToken(ResetPasswordUserToken resetPasswordUserToken);

    void deleteById(Integer id);
}
