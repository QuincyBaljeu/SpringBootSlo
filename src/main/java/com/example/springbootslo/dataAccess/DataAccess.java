package com.example.springbootslo.dataAccess;

import com.example.springbootslo.model.Appointment;
import com.example.springbootslo.model.Doctor;
import com.example.springbootslo.model.Patient;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface DataAccess {

    //Doctor
    int addDoctor(Doctor doctor);
    List<Doctor> getDoctors();

    //Patient
    int addPatient(Patient patient);
    List<Patient> getPatients();

    //appointment
    int addAppointment(Appointment appointment);
    List<Appointment> getAppointments();
    int updateAppointmentInfo(UUID appointmentId, UUID doctorId, UUID patientId, String description);
    Optional<Appointment> getAppointmentById(List<Appointment> list, UUID id);
}
