package com.example.coin.service;


import com.example.coin.model.User;
import com.example.coin.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder; // Mudei de BCryptPasswordEncoder para PasswordEncoder

    public User registerUser(User user) {
        // Codifica a senha do usuário antes de salvar no banco de dados
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public Optional<User> authenticateUser(String email, String password) {
        Optional<User> user = userRepository.findByEmail(email);
        // Verifica se o usuário existe e se a senha está correta
        if (user.isPresent() && passwordEncoder.matches(password, user.get().getPassword())) {
            return user;
        }
        return Optional.empty();
    }
}






