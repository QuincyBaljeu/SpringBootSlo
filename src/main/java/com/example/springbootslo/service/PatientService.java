package com.example.springbootslo.service;

import com.example.springbootslo.dataAccess.DataAccess;
import com.example.springbootslo.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    private final DataAccess pharmacyDataAccess;

    @Autowired
    public PatientService(@Qualifier("PharmacyDAO")DataAccess pharmacyDataAccess){
        this.pharmacyDataAccess = pharmacyDataAccess;
    }

    public int addPatient(Patient patient){
        return pharmacyDataAccess.addPatient(patient);
    }

    public List<Patient> getPatients(){
        return pharmacyDataAccess.getPatients();
    }

}
