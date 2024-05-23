package com.example.coin.service;

import com.example.coin.model.User;
import com.example.coin.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {
    private final UserRepository UserRepository;

    @Autowired
    public UserService(UserRepository UserRepository) {
        this.UserRepository = UserRepository;
    }

    public User createUser(User User) {
        User newUser = UserRepository.save(User);
        return newUser;
    }

    public List<User> retrieveUsers() {
        return UserRepository.findAll();
    }

    public Optional<User> retrieveUserById(UUID id) {
        return UserRepository.findById(id);
    }

    public User updateUser(User User) {
        return UserRepository.save(User);
    }

    public void deleteUser(UUID id) {
        UserRepository.deleteById(id);
    }

}
