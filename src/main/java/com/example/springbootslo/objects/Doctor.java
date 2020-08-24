package com.example.springbootslo.objects;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Doctor {

    @JsonProperty("name")
    private String name;

    public Doctor(String name) {
        this.name = name;
    }
}
