package com.example.coin.dto;

import com.example.coin.model.UserRole;


public record RegisterDTO(String login, String password, UserRole role) {
}
