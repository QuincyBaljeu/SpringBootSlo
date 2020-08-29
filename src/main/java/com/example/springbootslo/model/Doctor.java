package com.example.springbootslo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class Doctor {

    private String name;
    private UUID id;

    public Doctor(@JsonProperty("name") String name) {
        this.name = name;
        this.id = UUID.randomUUID();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
