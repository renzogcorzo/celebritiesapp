package com.mycompany.celebrityapp.domain;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public abstract class Person {
    private String firstName;
    private String lastName;
}
