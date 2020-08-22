package com.example.springbootslo.service;

import com.example.springbootslo.dataAccess.DataAccess;
import com.example.springbootslo.objects.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {

    private final DataAccess pharmacyDataAccess;

    @Autowired
    public DoctorService(@Qualifier("PharmacyDAO") DataAccess dataAccess){
        this.pharmacyDataAccess = dataAccess;
        pharmacyDataAccess.addDoctor(new Doctor("Jan smit"));
    }

    public int addDoctor(Doctor doctor){
        pharmacyDataAccess.addDoctor(doctor);
        return 1;
    }

    public List<Doctor> getDoctors(){
        return pharmacyDataAccess.getDoctors();
    }
}
