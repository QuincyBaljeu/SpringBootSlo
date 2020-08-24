package com.example.springbootslo.api;

import com.example.springbootslo.objects.Patient;
import com.example.springbootslo.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/patient")
@RestController
public class PatientController {

    private final PatientService patientService;

    @Autowired
    public PatientController(PatientService patientService){
        this.patientService = patientService;
    }

    @PostMapping
    public void addPatient(@RequestBody Patient patient){
        patientService.addPatient(patient);
    }

    @GetMapping
    public List<Patient> getPatients(){
        return patientService.getPatients();
    }

}
