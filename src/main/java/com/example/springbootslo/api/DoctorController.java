package com.example.springbootslo.api;

import com.example.springbootslo.model.Doctor;
import com.example.springbootslo.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/doctor")
@RestController
public class DoctorController {

    private final DoctorService doctorService;

    @Autowired
    public DoctorController(DoctorService doctorService){
        this.doctorService = doctorService;
    }

    @PostMapping
    public void addDoctor(@RequestBody Doctor doctor){
        doctorService.addDoctor(doctor);
    }

    @GetMapping
    public List<Doctor> getDoctors(){
        return doctorService.getDoctors();
    }
}
