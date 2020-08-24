package com.example.springbootslo.service;

import com.example.springbootslo.dataAccess.DataAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class AppointmentService {

    private final DataAccess appointmentDataAccess;

    @Autowired
    public AppointmentService(@Qualifier("PharmacyDAO") DataAccess dataAccess){
        this.appointmentDataAccess = dataAccess;
    }
}
