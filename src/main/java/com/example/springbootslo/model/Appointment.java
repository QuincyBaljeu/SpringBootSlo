package com.example.springbootslo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.UUID;


public class Appointment {

    private UUID appointmentId;
    private Doctor doctor;
    private Patient patient;
    private LocalDate date;
    private String description;
    private boolean active;

    public Appointment(@JsonProperty("date") String date) {
        LocalDate formattedDate;
        try {
            formattedDate = LocalDate.parse(date);
        } catch (DateTimeParseException e){
            System.out.println("Could not parse Date");
            return;
        }

        this.date = formattedDate;
        this.appointmentId = UUID.randomUUID();
        this.active = true;
    }

    public Appointment(LocalDate date){
        this.date = date;
        this.appointmentId = UUID.randomUUID();
        this.active = true;
    }

    public UUID getAppointmentId() {
        return appointmentId;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
