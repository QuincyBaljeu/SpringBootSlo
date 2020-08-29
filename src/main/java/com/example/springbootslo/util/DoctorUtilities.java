package com.example.springbootslo.util;


import com.example.springbootslo.model.Doctor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component("DoctorUtilities")
public class DoctorUtilities {

    /**
     *
     *
     * @param list list in which the method will search
     * @param id id of requested doctor
     *
     * @return Optional which will contain the found doctor, will be empty if not found
     *
     */
    public Optional<Doctor> getDoctorById(List<Doctor> list, UUID id) {
        return list.stream()
                .filter(doctor -> doctor.getId().equals(id))
                .findFirst();
    }
}
