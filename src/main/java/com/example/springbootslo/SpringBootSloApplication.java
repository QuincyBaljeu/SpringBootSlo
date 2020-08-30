package com.example.springbootslo;

import com.example.springbootslo.dataAccess.PharmacyDataAccess;
import com.example.springbootslo.model.Appointment;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.time.LocalDate;

@SpringBootApplication
public class SpringBootSloApplication {

    public static void main(String[] args) {
       ConfigurableApplicationContext context = SpringApplication.run(SpringBootSloApplication.class, args);

        PharmacyDataAccess dataAccess = context.getBean(PharmacyDataAccess.class);


    }

}
