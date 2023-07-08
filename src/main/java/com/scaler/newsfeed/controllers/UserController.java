package com.scaler.newsfeed.controllers;

import com.scaler.newsfeed.UserAlreadyExistsException;
import com.scaler.newsfeed.dtos.SignupUserRequestDto;
import com.scaler.newsfeed.dtos.SignupUserResponseDto;
import com.scaler.newsfeed.models.User;
import com.scaler.newsfeed.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
    UserService userService;
    @Autowired
    UserController(UserService userService){
        this.userService = userService;
    }
    public SignupUserResponseDto signUpUser(SignupUserRequestDto request){
        User user;
        try {
            user = userService.signupUser(request.getUsername(), request.getPassword());
            return SignupUserResponseDto.builder().userId(user.getId()).status("SUCCESS").build();
        }catch (UserAlreadyExistsException exception){
            return SignupUserResponseDto.builder().status("FAILURE").message(exception.getMessage()).build();
        }
    }
}
