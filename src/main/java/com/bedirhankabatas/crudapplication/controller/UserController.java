package com.bedirhankabatas.crudapplication.controller;

import com.bedirhankabatas.crudapplication.model.User;
import com.bedirhankabatas.crudapplication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;


    @PostMapping("/add")
    public User add(@RequestBody User user){
        return userService.addStudent(user);
    }

    @GetMapping("/getAll")
    public List<User> getAllUser(){
        return userService.getAllUser();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable("id") Long userId){
        return userService.getUserById(userId);
    }

    @DeleteMapping("/{id}")
    public String deleteUserById(@PathVariable("id") Long userId){
        return userService.deleteUserById(userId);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable("id") Long userId, @RequestBody User user){
        return userService.updateUser(userId,user);
    }


}
