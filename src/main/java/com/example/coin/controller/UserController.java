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
    private final UserService UserService;

    @Autowired
    public UserController(UserService UserService) {
        this.UserService = UserService;
    }

    @PostMapping
    public User post_User(@RequestBody User User) {
        return UserService.createUser(User);
    }

    @GetMapping
    public List<User> get_User() {
        return UserService.retrieveUsers();
    }

    @GetMapping("/{id}")
    public Optional<User> get_User(@PathVariable UUID id) {
        return UserService.retrieveUserById(id);
    }

    @PutMapping
    public User put_User(@RequestBody User User) {
        return UserService.updateUser(User);
    }

    @DeleteMapping("/{id}")
    public void delete_User(@PathVariable UUID id) {
        UserService.deleteUser(id);
    }

}
