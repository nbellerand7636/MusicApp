package com.bell.MusicApp.Controller;

import com.bell.MusicApp.Model.User;
import com.bell.MusicApp.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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
   public ResponseEntity login(@RequestBody User user){
      return userService.login(user);
   }

}
