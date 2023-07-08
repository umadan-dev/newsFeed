package com.scaler.newsfeed.commands;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CommandRegistry {
    List<Command> commands;
    @Autowired
    CommandRegistry(SignupUserCommand signupUserCommand, LoginUserCommand loginUserCommand){
        commands=new ArrayList<>();
        commands.add(signupUserCommand);
        commands.add(loginUserCommand);
    }
    public void execute(String query){
        for(Command command: commands){
            if(command.matched(query)) {
                command.execute(query);
                return;
            }
        }
        System.out.println("No Command found with " +query);
    }
}
