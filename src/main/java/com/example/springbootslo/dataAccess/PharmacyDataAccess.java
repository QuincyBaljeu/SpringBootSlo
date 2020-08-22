package com.example.springbootslo.dataAccess;

import com.example.springbootslo.objects.Doctor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("PharmacyDAO")
public class PharmacyDataAccess implements DataAccess {

    private static List<Doctor> doctorlist = new ArrayList<>();

    @Override
    public int addDoctor(Doctor doctor) {
        doctorlist.add(doctor);
        return 1;
    }

    @Override
    public List<Doctor> getDoctors() {
        return doctorlist;
    }
}
