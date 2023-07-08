package com.scaler.newsfeed.commands;

import com.scaler.newsfeed.controllers.UserController;
import com.scaler.newsfeed.dtos.LoginUserRequestDto;
import com.scaler.newsfeed.dtos.LoginUserResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoginUserCommand implements Command{

    UserController userController;

    @Autowired
    LoginUserCommand(UserController userController){
        this.userController = userController;
    }
    @Override
    public boolean matched(String query) {
        String[] inWords = query.split(" ");
        return inWords.length == 3 && inWords[0].equals(CommandKeywords.LOGIN);
    }

    @Override
    public void execute(String query) {
        String[] inWords = query.split(" ");
        String username = inWords[1];
        String password = inWords[2];

        LoginUserRequestDto request = LoginUserRequestDto.builder().username(username).password(password).build();
        LoginUserResponseDto response = userController.loginUser(request);
        if(response.getStatus().equals("SUCCESS")){
            System.out.println("User login successful, userID: "+response.getUserId());
        }else{
            System.out.println("Incorrect username and password");
        }

    }
}
