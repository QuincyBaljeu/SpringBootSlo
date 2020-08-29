package com.example.springbootslo.util;

import com.example.springbootslo.model.Patient;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component("PatientUtilities")
public class PatientUtilities {

    /**
     *
     *
     * @param list list in which the method will search
     * @param id id of requested patient
     *
     * @return Optional which will contain the found patient, will be empty if not found
     *
     */

    public Optional<Patient> getPatientById(List<Patient> list, UUID id) {
        return list.stream()
                .filter(patient -> patient.getId().equals(id))
                .findFirst();
    }
}
