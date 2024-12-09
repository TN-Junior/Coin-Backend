package com.example.coin.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class WebConfig {
    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOrigin("http://localhost:3000");
        config.addAllowedOrigin("https://coin-pa.vercel.app/");
        config.addAllowedOrigin("https://web-coin-railway-git-main-tarynascimentos-projects.vercel.app/");
        config.addAllowedOrigin("http://localhost:5173");
        config.addAllowedOrigin("https://coin-frontend2-0.vercel.app");
        config.addAllowedOrigin("https://coinfrontend.vercel.app/dashboard");
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
}
