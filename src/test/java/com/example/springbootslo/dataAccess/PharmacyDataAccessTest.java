package com.example.springbootslo.dataAccess;

import com.example.springbootslo.model.Appointment;
import com.example.springbootslo.model.Doctor;
import com.example.springbootslo.model.Patient;
import com.example.springbootslo.util.AppointmentUtilities;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDate;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(PharmacyDataAccess.class)
class PharmacyDataAccessTest {

    @Autowired
    private MockMvc mvc;

    @Test
    void updateAppointmentInfo() {

        //BUG WERKT NIET

        RequestBuilder appointmentPostBuilder = MockMvcRequestBuilders.post("api/appointment");

        UUID appointmentId = UUID.randomUUID();
        Doctor testDoctor = new Doctor("Quincy Baljeu");
        Patient testPatient = new Patient("Jan Janssen");

        Appointment testAppointment = new Appointment("2020-08-30");

        try {
            mvc.perform(appointmentPostBuilder).andReturn();
        } catch (Exception e){
            System.out.println("INVALID URL");
            return;
        }

        RequestBuilder appointmentPutBuilder = MockMvcRequestBuilders.put("api/appointment" + appointmentId +"/" + testDoctor.getId() + "/" + testPatient.getId() + "TEST");

        try {
            mvc.perform(appointmentPutBuilder).andReturn();
        } catch (Exception e){
            System.out.println("INVALID URL");
            return;
        }

        boolean check = false;

        //Weet niet hoe ik een object uit het request kan halen.
    }

    @Test
    void updateAppointmentActivity() {
        //Zelfde probleem ,Weet niet hoe ik een object uit het request kan halen.
    }
}