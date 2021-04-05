package com.mycompany.celebrityapp.domain;

import lombok.Getter;

import java.util.HashSet;
import java.util.Set;

@Getter
public class PersonWithKnownPeople extends Person {

    private Set<Long> knowPeople;

    public PersonWithKnownPeople(){
        knowPeople = new HashSet<>();
    }

    public PersonWithKnownPeople(Long personId, String firstName, String lastName){
        this();
        this.setPersonId(personId);
        this.setFirstName(firstName);
        this.setLastName(lastName);
        addKnownPeople(personId);
    }

    public void addKnownPeople(Long personId){
        knowPeople.add(personId);
    }


}
