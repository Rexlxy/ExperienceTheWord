package com.ETW;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ExperienceTheWordApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExperienceTheWordApplication.class, args);
    }
}
