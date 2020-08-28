package com.example.springbootslo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.cglib.core.Local;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;


public class Appointment {

    private Doctor doctor;
    private Patient patient;
    private LocalDate date;
    private String description;
    private boolean present;

    public Appointment(@JsonProperty("date") String date) {
        LocalDate formattedDate;
        try {
            formattedDate = LocalDate.parse(date);
        } catch (DateTimeParseException e){
            System.out.println("Could not parse Date");
            return;
        }

        this.date = formattedDate;
    }

    public Appointment(LocalDate date){
        this.date = date;
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
