package com.mycompany.celebrityapp.domain;

import lombok.Getter;

import java.util.HashSet;
import java.util.Set;

@Getter
public class PersonWithKnownPeople extends Person {

    private Set<String> knowPeople;

    public PersonWithKnownPeople(){
        knowPeople = new HashSet<>();
    }

    public PersonWithKnownPeople(String firstName, String lastName){
        this();
        this.setFirstName(firstName);
        this.setLastName(lastName);
        addKnownPeople(firstName + " " + lastName);
    }

    public void addKnownPeople(String personFullName){
        knowPeople.add(personFullName);
    }


}
