package com.bell.MusicApp.Service;

import com.bell.MusicApp.Model.User;
import com.bell.MusicApp.Repository.UserRepository;
import com.bell.MusicApp.exception.PasswrodIncorrectException;
import com.bell.MusicApp.exception.UserNotFoundException;
import com.bell.MusicApp.requests.UserLoginRequest;
import com.bell.MusicApp.responses.ErrorResponse;
import com.bell.MusicApp.responses.OkResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.PasswordAuthentication;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    //return user by id
    public User getUser(Long id) {
       return userRepository.findById(id).get();
    }
    //return all users
    public List<User> getUsers(){
        return  userRepository.findAll();
    }
    //create user
    public User createUser(User user){
        return userRepository.save(user);
    }

    //login to a user account
    public void login(UserLoginRequest user){
        User myuser=userRepository.findByUsername(user.getUsername());


        if(myuser!=null){

            if(user.getPassword().equals(myuser.getPassword())){

                // maybe add somthing here ... ( returning jwt )
            }
            else{

            throw new PasswrodIncorrectException("Password incorrect");
            }
        }

        else{

            throw new UserNotFoundException("Username not found exception");
        }

    }

}
