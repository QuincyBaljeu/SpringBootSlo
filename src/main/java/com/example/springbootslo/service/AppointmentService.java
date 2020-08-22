package com.example.springbootslo.service;

import com.example.springbootslo.dataAccess.DataAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class AppointmentService {

    private final DataAccess appointmentDao;

    @Autowired
    public AppointmentService(@Qualifier("AppointmentDAO") DataAccess dataAccess){
        this.appointmentDao = dataAccess;
    }
}
