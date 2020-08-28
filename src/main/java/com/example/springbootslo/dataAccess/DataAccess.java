package com.example.springbootslo.dataAccess;

import com.example.springbootslo.model.Appointment;
import com.example.springbootslo.model.Doctor;
import com.example.springbootslo.model.Patient;

import java.util.List;
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
    int updateAppointmentInfo(UUID doctorId, UUID patientId);
}
