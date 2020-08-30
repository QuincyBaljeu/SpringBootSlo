package com.example.springbootslo.dataAccess;

import com.example.springbootslo.model.Doctor;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(PharmacyDataAccess.class)
class PharmacyDataAccessTest {


    private MockMvc mvc;

    @Test
    void addDoctor() throws Exception {


    }

    @Test
    void addPatient() {
    }

    @Test
    void addAppointment() {
    }

    @Test
    void updateAppointmentInfo() {
    }

    @Test
    void updateAppointmentActivity() {
    }
}