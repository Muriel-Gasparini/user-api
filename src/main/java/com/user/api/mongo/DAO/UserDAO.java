package com.user.api.mongo.DAO;

import com.user.api.mongo.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Optional;

@Component
public class UserDAO {
    @Autowired
    private UserRepository repository;

    public Collection<User> getUsers(){
        return repository.findAll();
    }

    public User createUser(User user) {
        return repository.insert(user);
    }

    public Optional<User> editUser(Integer id, User user) {
        Optional<User> userRepository = repository.findById(id);

        userRepository.ifPresent(b -> b.setName(user.getName()));
        userRepository.ifPresent(b -> b.setCpf(user.getCpf()));
        userRepository.ifPresent(b -> b.setBirthDate(user.getBirthDate()));
        userRepository.ifPresent(b -> b.setAddress(user.getAddress()));
        userRepository.ifPresent(b -> b.setAge(user.getAge()));
        userRepository.ifPresent(b -> repository.save(user));

        return userRepository;
    }

    public Optional<User> deleteUser(Integer id) {
        Optional<User> userRepository = repository.findById(id);
        userRepository.ifPresent(b -> repository.deleteById(id));
        return userRepository;
    }

    public Optional<User> getUserById(Integer id) {
        Optional<User> userRepository = repository.findById(id);
        return userRepository;
    }
}
