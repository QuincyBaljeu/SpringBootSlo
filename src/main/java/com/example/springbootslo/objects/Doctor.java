package com.example.springbootslo.objects;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Doctor {

    private String name;

    public Doctor(@JsonProperty("name") String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
