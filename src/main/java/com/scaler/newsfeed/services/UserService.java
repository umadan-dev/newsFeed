package com.scaler.newsfeed.services;

import com.scaler.newsfeed.UserAlreadyExistsException;
import com.scaler.newsfeed.models.User;
import com.scaler.newsfeed.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService{
    UserRepository userRepository;
    UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    public User signupUser(String username, String password) throws UserAlreadyExistsException {
        Optional<User> userOptional= userRepository.findByUsername(username);
        if(userOptional.isPresent()){
            throw new UserAlreadyExistsException();
        }
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user = userRepository.save(user);
        return user;
    }
}
