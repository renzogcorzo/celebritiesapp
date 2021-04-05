package com.mycompany.celebrityapp.domain;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public abstract class Person {
    private long personId;
    private String firstName;
    private String lastName;
}
