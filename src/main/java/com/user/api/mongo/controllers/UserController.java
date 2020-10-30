package com.user.api.mongo.controllers;

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

    @GetMapping("/user")
    public Collection<User> getUser(){
        return userService.getUsers();
    }

    @GetMapping("/user/{id}")
    public Optional<User> getUserById(@PathVariable Integer id) {
        return userService.getUserById(id);
    }

    @PostMapping("/user")
    public User setUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @DeleteMapping("/user/{id}")
    public Optional<User> deleteUser(@PathVariable Integer id) {
        return userService.deleteUser(id);
    }

    @PutMapping("/user/{id}")
    public Optional<User> editUser(@PathVariable Integer id, @RequestBody User user) {
        return userService.editUser(id, user);
    }
}
