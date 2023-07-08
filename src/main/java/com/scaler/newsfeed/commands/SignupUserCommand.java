package com.scaler.newsfeed.commands;

import com.scaler.newsfeed.controllers.UserController;
import com.scaler.newsfeed.dtos.SignupUserRequestDto;
import com.scaler.newsfeed.dtos.SignupUserResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SignupUserCommand implements Command{
    UserController userController;
    @Autowired
    SignupUserCommand(UserController userController){
        this.userController=userController;

    }
    @Override
    public boolean matched(String query) {
        String[] inWords = query.split(" ");
        return inWords.length == 3 && inWords[0].equals(CommandKeywords.SIGNUP);
    }

    @Override
    public void execute(String query) {
        String[] inWords = query.split(" ");
        String username = inWords[1];
        String password = inWords[2];

        SignupUserRequestDto request = SignupUserRequestDto.builder().username(username).password(password).build();

        //Call controller
        SignupUserResponseDto response = userController.signUpUser(request);
        if(response.getStatus().equals("SUCCESS")){
            System.out.println("User created with id "+response.getUserId());
        }
        else {
            System.out.println("User "+ username +" already exists");
        }


    }
}
