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

        Doctor doctorJan = new Doctor("Jan smit");

        Patient patient1 = new Patient("Quincy Baljeu");

       Appointment appointment1 = new Appointment(doctorJan, patient1);
    }

}
