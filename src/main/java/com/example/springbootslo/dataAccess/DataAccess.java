package com.example.springbootslo.dataAccess;

import com.example.springbootslo.objects.Doctor;
import com.example.springbootslo.objects.Patient;

import java.util.List;

public interface DataAccess {

    //Doctor
    int addDoctor(Doctor doctor);
    List<Doctor> getDoctors();

    //Patient
    int addPatient(Patient patient);
    List<Patient> getPatients();

}
