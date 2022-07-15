package com.smartphoneshop.controllers;

import com.smartphoneshop.base.BaseController;
import com.smartphoneshop.dto.UserChangePasswordDTO;
import com.smartphoneshop.dto.pagination.PaginateDTO;
import com.smartphoneshop.dto.update.UpdateUserDTO;
import com.smartphoneshop.entity.User;
import com.smartphoneshop.exceptions.AppException;
import com.smartphoneshop.exceptions.NotFoundException;
import com.smartphoneshop.services.IUserService;
import com.smartphoneshop.specifications.GenericSpecification;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@SecurityRequirement(name = "Authorization")
@CrossOrigin("*")
public class UserController extends BaseController<User> {
    @Autowired
    private IUserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @GetMapping
    @PreAuthorize("@userAuthorizer.isAdmin(authentication)")
    public ResponseEntity<?> getAllUser(@RequestParam(name = "page", required = false) Integer page,
                                        @RequestParam(name = "perPage", required = false) Integer perPage,
                                        HttpServletRequest request){
        GenericSpecification<User> specification = new GenericSpecification<User>().getBasicQuery(request);
        PaginateDTO<User> paginateUsers = userService.getList(page, perPage, specification);

        return this.resPagination(paginateUsers);
    }

    @GetMapping("/{userId}")
    @PreAuthorize("@userAuthorizer.isAdmin(authentication) || @userAuthorizer.isYourself(authentication, #userId)")
    public ResponseEntity<?> getUserById(@PathVariable(name = "userId") Integer userId){
        User user = userService.findById(userId);
        if(user == null)
            throw new NotFoundException("Not found user");
        return this.resSuccess(user);
    }

    @PatchMapping("/{userId}")
    @PreAuthorize("@userAuthorizer.isAdmin(authentication) || @userAuthorizer.isYourself(authentication, #userId)")
    public ResponseEntity<?> updateUser(@RequestBody @Valid UpdateUserDTO userDTO,
                                        @PathVariable("userId") Integer userId){
        User user = userService.findById(userId);
        if(user == null)
            throw new NotFoundException("Not found user");

        User savedUser = userService.update(userDTO, user);
        return this.resSuccess(savedUser);
    }

    @DeleteMapping("/{userId}")
    @PreAuthorize("@userAuthorizer.isAdmin(authentication)")
    public ResponseEntity<?> deleteUser(@PathVariable("userId") Integer userId){
        User user = userService.findById(userId);
        if (user == null) {
            throw new NotFoundException("Not found user");
        }

        if (user.getOrder().getOrderItems().size() != 0) {
            throw new AppException("Cannot delete user");
        }

        userService.deleteById(userId);

        return new ResponseEntity<>("Delete user successful", HttpStatus.OK);
    }

    @PatchMapping("/password")
    public ResponseEntity<?> changePassword(@RequestBody @Valid UserChangePasswordDTO userChangePasswordDTO, HttpServletRequest request) {
        User requestedUser = (User) request.getAttribute("user");

        User user = userService.findByUsername(requestedUser.getUsername());

        if (!passwordEncoder.matches(userChangePasswordDTO.getOldPassword(), user.getPassword())) {
            throw new AppException("oldPassword is incorrect");
        }

        user.setPassword(passwordEncoder.encode(userChangePasswordDTO.getNewPassword()));

        User updatedUser = userService.updateUser(user);

        return this.resSuccess(updatedUser);
    }
}
