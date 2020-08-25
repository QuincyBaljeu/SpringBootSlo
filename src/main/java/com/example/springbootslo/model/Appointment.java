package com.example.springbootslo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;


public class Appointment {

    private Doctor doctor;
    private Patient patient;
    private LocalDate date;
    private String description;
    private boolean present;

    public Appointment(@JsonProperty("date") String date) {
        this.description = date;
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

    public boolean isPresent() {
        return present;
    }

    public void setPresent(boolean present) {
        this.present = present;
    }
}
