package com.example.anime;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
@MapperScan("com.example.anime.Dao")
public class AnimeApplication {
    public static void main(String[] args) {
        SpringApplication.run(AnimeApplication.class, args);
    }
}