package com.example.springbootslo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringBootSloApplication {

    public static void main(String[] args) {
       ConfigurableApplicationContext context = SpringApplication.run(SpringBootSloApplication.class, args);


    }

}
