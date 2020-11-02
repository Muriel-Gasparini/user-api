package com.user.api.mongo.controllers;

import com.user.api.mongo.models.Address;
import com.user.api.mongo.models.User;
import com.user.api.mongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/v1")
public class UserController {
    @Autowired
    private UserService userService;
    
    @CrossOrigin
    @GetMapping("/user")
    public Collection<User> getUser(){
        return userService.getUsers();
    }

    @CrossOrigin
    @GetMapping("/user/{id}")
    public Optional<User> getUserById(@PathVariable Integer id) {
        return userService.getUserById(id);
    }

    @CrossOrigin
    @PostMapping("/user")
    public User setUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @CrossOrigin
    @DeleteMapping("/user/{id}")
    public Optional<User> deleteUser(@PathVariable Integer id) {
        return userService.deleteUser(id);
    }

    @CrossOrigin
    @PutMapping("/user/{id}")
    public Optional<User> editUser(@PathVariable Integer id, @RequestBody User user) {
        return userService.editUser(id, user);
    }
}
