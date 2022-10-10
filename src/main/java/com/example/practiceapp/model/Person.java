package com.example.practiceapp.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.lang.NonNull;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.UUID;

public class Person{

    @NotNull
    private  UUID id;

    @NotNull
    @NotBlank
    private  String name;

    @NotNull
    public Person( UUID id,
                  String name) {
        this.id = id;
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public UUID getId() {
        return id;
    }

}
