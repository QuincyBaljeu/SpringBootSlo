package com.example.springbootslo.dataAccess;

import com.example.springbootslo.objects.Doctor;

import java.util.List;

public interface DataAccess {

    int addDoctor(Doctor doctor);
    List<Doctor> getDoctors();
}
