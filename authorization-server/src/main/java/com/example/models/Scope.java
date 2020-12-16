package com.example.models;

import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.Size;

@Data
public class Scope {

    @Id
    private String id;

    @Size(max = 18)
    private String name;

}
