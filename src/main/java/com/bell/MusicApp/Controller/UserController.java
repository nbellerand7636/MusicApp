package com.bell.MusicApp.Controller;

import com.bell.MusicApp.Model.User;
import com.bell.MusicApp.Service.UserService;
import com.bell.MusicApp.helpers.CODE;
import com.bell.MusicApp.requests.UserLoginRequest;
import com.bell.MusicApp.responses.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {
   @Autowired
   private UserService userService;

   @PostMapping("/user")
   public User createUser(@RequestBody User user){
      return userService.createUser(user);
   }

   @GetMapping("/user/{userId}")
   public User getUser(@PathVariable Long userId){
      return userService.getUser(userId);
   }
   @GetMapping("/users")
   public List<User> userList(){
      return userService.getUsers();
   }

   /* @PostMapping("/{username}")
   public void updateUsername(Long userId,String userName,String password){

   }
   */

   @PostMapping("/login")
   public ResponseEntity login(@RequestBody UserLoginRequest userLoginRequest){

      userService.login(userLoginRequest);
      Response<Object> response = Response.builder()
              .message("user is logged in successfully.")
              .code(CODE.OK.getId())
              .success(true)
              .build();
      return new ResponseEntity<>(response, new HttpHeaders(), HttpStatus.OK);
   }

}
