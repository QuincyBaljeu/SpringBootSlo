package com.example.springbootslo.dataAccess;

import com.example.springbootslo.objects.Doctor;
import com.example.springbootslo.objects.Patient;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("PharmacyDAO")
public class PharmacyDataAccess implements DataAccess {

    private static List<Doctor> doctorlist = new ArrayList<>();
    private static List<Patient> patientList = new ArrayList<>();

    @Override
    public int addDoctor(Doctor doctor) {
        doctorlist.add(doctor);
        return 1;
    }

    @Override
    public List<Doctor> getDoctors() {
        return doctorlist;
    }

    @Override
    public int addPatient(Patient patient) {
        patientList.add(new Patient(patient.getName()));
        return 1;
    }

    @Override
    public List<Patient> getPatients() {
        return patientList;
    }
}
