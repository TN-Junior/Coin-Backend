package com.example.coin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.example.coin.repository")
@EntityScan(basePackages = "com.example.coin.model")
public class CoinApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoinApplication.class, args);
	}
}
