package com.example.coin.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Desabilitar CSRF conforme necessário
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/login", "/signup", "/api/contas").permitAll() // Permitir acesso público ao endpoint
                        .anyRequest().authenticated() // Requer autenticação para outras requisições
                )
                .cors(cors -> {}); // Habilitar suporte a CORS

        return http.build();
    }
}







