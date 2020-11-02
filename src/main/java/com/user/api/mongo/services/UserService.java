package com.user.api.mongo.services;

import com.user.api.mongo.DAO.UserDAO;
import com.user.api.mongo.models.Address;
import com.user.api.mongo.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserDAO userDAO;

    public Collection<User> getUsers(){
        return userDAO.getUsers();
    }

    public User createUser(User user) {
        return userDAO.createUser(user);
    }

    public Optional<User> editUser(Integer id, User user) {
        return userDAO.editUser(id, user);
    }

    public Optional<User> deleteUser(Integer id) {
        return userDAO.deleteUser(id);
    }

    public Optional<User> getUserById(Integer id) {
        return userDAO.getUserById(id);
    }
}
