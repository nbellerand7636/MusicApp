package com.bell.MusicApp.Service;

import com.bell.MusicApp.Model.User;
import com.bell.MusicApp.Repository.UserRepository;
import com.bell.MusicApp.responses.ErrorResponse;
import com.bell.MusicApp.responses.OkResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

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
    public ResponseEntity login(User user){
        User myuser=userRepository.findByUsername(user.getUsername());

        ErrorResponse errorResponse=new ErrorResponse();
        if(myuser!=null){

            if(user.getPassword().equals(myuser.getPassword())){
                OkResponse okResponse=new OkResponse();
                okResponse.setMessage("Logged in!!");

                return  ResponseEntity.ok().body(okResponse);
            }
            else{
              errorResponse.setMessage("passsword incorrect");
              return ResponseEntity.badRequest().body(errorResponse);

            }
        }
        else{

            errorResponse.setMessage("User not found exception.");

            return ResponseEntity.badRequest().body(errorResponse);
        }

    }

}
