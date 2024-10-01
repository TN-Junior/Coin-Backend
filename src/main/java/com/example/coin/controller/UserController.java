package com.example.coin.controller;


import com.example.coin.model.User;
import com.example.coin.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("signupcoin")
@CrossOrigin(origins = "http://localhost:5173") // Para permitir requisições do seu React app
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<String> signup(@Valid @RequestBody User user) {
        try {
            userService.createUser(user);
            return ResponseEntity.ok("Usuário cadastrado com sucesso!");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}

