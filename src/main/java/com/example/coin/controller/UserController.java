package com.example.coin.controller;



import com.example.coin.model.User;
import com.example.coin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<String> registerUser(@Valid @RequestBody User user) {
        try {
            userService.registerUser(user);
            return ResponseEntity.ok("Cadastro bem-sucedido");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erro ao criar conta. Tente novamente.");
        }
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestParam String email, @RequestParam String password) {
        return userService.authenticateUser(email, password)
                .map(user -> ResponseEntity.ok("Login bem-sucedido"))
                .orElseGet(() -> ResponseEntity.status(401).body("Credenciais inválidas"));
    }
}


