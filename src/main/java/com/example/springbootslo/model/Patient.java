package com.example.springbootslo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Patient {

    private String name;

    public Patient(@JsonProperty("name") String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
