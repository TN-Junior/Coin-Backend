package com.example.coin.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.UUID;


@Data
@MappedSuperclass
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;

}
