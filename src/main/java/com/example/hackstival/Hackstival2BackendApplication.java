package com.example.hackstival;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class Hackstival2BackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(Hackstival2BackendApplication.class, args);
    }

}
