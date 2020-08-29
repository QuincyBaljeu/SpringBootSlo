package com.example.springbootslo.api;

import com.example.springbootslo.model.Appointment;
import com.example.springbootslo.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("api/appointment")
@RestController
public class AppointmentController {

    private final AppointmentService appointmentService;

    @Autowired
    public AppointmentController(AppointmentService appointmentService){
        this.appointmentService = appointmentService;
    }

    @PostMapping
    public void addAppointment(@RequestBody Appointment appointment){
        appointmentService.addAppointment(appointment);
    }

    @GetMapping
    public List<Appointment> getAppointments(){
        return appointmentService.getAppointments();
    }

//    @PutMapping(path = "/{doctor}/{patient}/{description")
//    public void updateInfo(@PathVariable("doctor") UUID doctorId,
//        @PathVariable("patient") UUID patientId,
//        @PathVariable("description") String description){
//
//        appointmentService.updateAppointmentInfo(doctorId, patientId, description);
//    }

    @PutMapping(path = "{appointment}/{doctor}/{patient}/{description}")
    public void updateAppointmentInfo(@PathVariable("appointment") UUID appointmentId,
                                      @PathVariable("doctor") UUID doctorId,
                                      @PathVariable("patient") UUID patientId,
                                      @PathVariable("description") String description){

        appointmentService.updateAppointmentInfo(appointmentId, doctorId, patientId, description);
    }
}
