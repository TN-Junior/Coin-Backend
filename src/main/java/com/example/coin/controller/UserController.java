package com.example.coin.controller;

import com.example.coin.model.User;
import com.example.coin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("User")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public User postUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @GetMapping
    public List<User> getUsers() {
        return userService.retrieveUsers();
    }

    @GetMapping("/{id}")
    public Optional<User> getUser(@PathVariable UUID id) {
        return userService.retrieveUserById(id);
    }

    @PutMapping
    public User putUser(@RequestBody User user) {
        return userService.updateUser(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable UUID id) {
        userService.deleteUser(id);
    }

    @PostMapping("/login")
    public User loginUser(@RequestBody User user) {
        return userService.authenticateUser(user.getEmail(), user.getPassword());
    }
}
