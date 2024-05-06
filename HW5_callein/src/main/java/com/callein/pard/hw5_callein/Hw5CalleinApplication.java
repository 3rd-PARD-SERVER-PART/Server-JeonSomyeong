package com.callein.pard.hw5_callein;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class Hw5CalleinApplication {

    public static void main(String[] args) {
        SpringApplication.run(Hw5CalleinApplication.class, args);
    }

}
