package com.example.springbootslo.service;

import com.example.springbootslo.dataAccess.DataAccess;
import com.example.springbootslo.model.Appointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AppointmentService {

    private final DataAccess pharmacyDataAccess;

    @Autowired
    public AppointmentService(@Qualifier("PharmacyDAO") DataAccess dataAccess){
        this.pharmacyDataAccess = dataAccess;
    }

    public int addAppointment(Appointment appointment){
        return pharmacyDataAccess.addAppointment(appointment);
    }

    public List<Appointment> getAppointments(){
        return pharmacyDataAccess.getAppointments();
    }

    public int updateAppointmentInfo(UUID appointmentID, UUID doctorId, UUID patientID, String description){
        return pharmacyDataAccess.updateAppointmentInfo(appointmentID, doctorId, patientID, description);
    }
}
