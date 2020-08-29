package com.example.springbootslo.dataAccess;

import com.example.springbootslo.model.Appointment;
import com.example.springbootslo.model.Doctor;
import com.example.springbootslo.model.Patient;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component("PharmacyDAO")
public class PharmacyDataAccess implements DataAccess {

    private static List<Doctor> doctorlist = new ArrayList<>();
    private static List<Patient> patientList = new ArrayList<>();
    private static List<Appointment> appointmentList = new ArrayList<>();

    @Override
    public int addDoctor(Doctor doctor) {
        doctorlist.add(doctor);
        return 1;
    }

    @Override
    public List<Doctor> getDoctors() {
        return this.doctorlist;
    }

    @Override
    public int addPatient(Patient patient) {
        patientList.add(new Patient(patient.getName()));
        return 1;
    }

    @Override
    public List<Patient> getPatients() {
        return this.patientList;
    }

    @Override
    public int addAppointment(Appointment appointment) {
        appointmentList.add(new Appointment(appointment.getDate()));
        return 1;
    }

    @Override
    public List<Appointment> getAppointments() {
        return this.appointmentList;
    }

    @Override
    public int updateAppointmentInfo(UUID appointmentId,UUID doctorId, UUID patientId, String description) {
        System.out.println("appointment: " + appointmentId);
        System.out.println("Doctor: " + doctorId);
        System.out.println("Patient: " + patientId);
        System.out.println("Desc: " + description);

        System.out.println(getAppointmentById(appointmentList,appointmentId));

        return 1;
    }

    @Override
    public Optional<Appointment> getAppointmentById(List<Appointment> list, UUID id) {
        return list.stream()
                .filter(appointment -> appointment.getAppointmentId().equals(id))
                .findFirst();
    }


}
