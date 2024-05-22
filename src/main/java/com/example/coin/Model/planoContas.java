package com.example.coin.Model;

import jakarta.persistence.*;

import java.util.List;
import java.util.ArrayList;

@Entity
public class planoContas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;