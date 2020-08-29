package com.example.springbootslo.util;


import com.example.springbootslo.model.Doctor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component("DoctorUtilities")
public class DoctorUtilities {

    public Optional<Doctor> getDoctorById(List<Doctor> list, UUID id) {
        return list.stream()
                .filter(doctor -> doctor.getId().equals(id))
                .findFirst();
    }
}
