package com.example.springbootslo;

import com.example.springbootslo.objects.Appointment;
import com.example.springbootslo.objects.Doctor;
import com.example.springbootslo.objects.Patient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringBootSloApplication {

    public static void main(String[] args) {
       ConfigurableApplicationContext context = SpringApplication.run(SpringBootSloApplication.class, args);


    }

}
