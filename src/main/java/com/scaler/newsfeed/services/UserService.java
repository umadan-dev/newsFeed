package com.scaler.newsfeed.services;

import com.scaler.newsfeed.exceptions.IncorrectPasswordException;
import com.scaler.newsfeed.exceptions.UserAlreadyExistsException;
import com.scaler.newsfeed.exceptions.UserDoesNotExistException;
import com.scaler.newsfeed.models.Session;
import com.scaler.newsfeed.models.SessionTokenStatus;
import com.scaler.newsfeed.models.User;
import com.scaler.newsfeed.repositories.SessionRepository;
import com.scaler.newsfeed.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserService{
    UserRepository userRepository;
    SessionRepository sessionRepository;
    UserService(UserRepository userRepository, SessionRepository sessionRepository){
        this.userRepository = userRepository;
        this.sessionRepository = sessionRepository;
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
    public User loginUser(String username, String password) throws UserDoesNotExistException, IncorrectPasswordException {
        Optional<User> userOptional= userRepository.findByUsername(username);
        if(userOptional.isEmpty()){
            throw new UserDoesNotExistException();
        }
        User user = userOptional.get();
        if(!user.getPassword().equals(password)){
            throw new IncorrectPasswordException();
        }
        Optional<Session> sessionOptional = sessionRepository.findByUser(user);
        Session session;
        if(sessionOptional.isEmpty()) {
            session=new Session();
            session.setTokenStatus(SessionTokenStatus.ACTIVE);
            session.setUser(user);
        }
        else {
            session = sessionOptional.get();
            session.setTokenStatus(SessionTokenStatus.ACTIVE);;
        }
        session.setToken(UUID.randomUUID().toString());
        sessionRepository.save(session);
        return user;
    }
}
