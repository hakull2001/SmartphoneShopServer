package com.smartphoneshop.services.Impl;

import com.smartphoneshop.base.BasePagination;
import com.smartphoneshop.constants.StatusCodeEnum;
import com.smartphoneshop.dto.SignUpDTO;
import com.smartphoneshop.dto.UserUpdateDTO;
import com.smartphoneshop.dto.pagination.PaginateDTO;
import com.smartphoneshop.dto.update.UpdateUserDTO;
import com.smartphoneshop.entity.RegistrationUserToken;
import com.smartphoneshop.entity.User;
import com.smartphoneshop.repositories.IRegistrationUserTokenRepository;
import com.smartphoneshop.repositories.IUserRepository;
import com.smartphoneshop.services.IUserService;
import com.smartphoneshop.specifications.GenericSpecification;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService extends BasePagination<User, IUserRepository> implements IUserService {
    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private IRegistrationUserTokenRepository registrationUserTokenRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(IUserRepository userRepository){
        super(userRepository);
    }

    @Override
    public PaginateDTO<User> getList(Integer page, Integer perPage, GenericSpecification<User> specification) {
        return this.paginate(page, perPage, specification);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User create(SignUpDTO signUpDTO) {
        User user = modelMapper.map(signUpDTO, User.class);
        return userRepository.save(user);
    }

    @Override
    public void activeUser(String token) {
        RegistrationUserToken registrationUserToken = registrationUserTokenRepository.findByToken(token);
        User user = registrationUserToken.getUser();
        user.setStatus(StatusCodeEnum.ACTIVE);

        userRepository.save(user);

        registrationUserTokenRepository.deleteById(registrationUserToken.getId());
    }

    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public void create(User user) {
        userRepository.save(user);
    }

    @Override
    public User findById(Integer userId) {
        return userRepository.findById(userId).orElse(null);
    }

    @Override
    public User update(UpdateUserDTO userUpdateDTO, User currentUser) {
        User updated = modelMapper.map(userUpdateDTO, User.class);
        modelMapper.map(updated, currentUser);
        if(userUpdateDTO.getPassword() != null)
            currentUser.setPassword(passwordEncoder.encode(userUpdateDTO.getPassword()));
        return userRepository.save(currentUser);
    }

    @Override
    public void deleteById(Integer userId) {
        userRepository.deleteById(userId);
    }

}
