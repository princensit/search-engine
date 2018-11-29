package com.example.searchengine.response;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class Employee {

    @Size(max = 50)
    private final String firstName;

    @Size(max = 50)
    private final String lastName;

    @Email
    @Size(min = 5, max = 254)
    private final String email;

    private final int age;
}
