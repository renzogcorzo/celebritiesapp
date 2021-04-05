package com.mycompany.celebrityapp.service;

import com.mycompany.celebrityapp.domain.PersonWithKnownPeople;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CelebrityFinderServiceTest {

    private List<PersonWithKnownPeople> people;

    @BeforeEach
    void prepare(){
        people = new ArrayList<>();
    }

    @Test
    void getCelebrityWithOneCelebrity() {
        //given
        PersonWithKnownPeople person1 = new PersonWithKnownPeople(1l, "Joe", "Doe");
        person1.addKnownPeople(3l);

        PersonWithKnownPeople person2 = new PersonWithKnownPeople(2l, "Mary", "Jones");
        person2.addKnownPeople(3l);

        PersonWithKnownPeople person3 = new PersonWithKnownPeople(3l, "Will", "Smith");

        people.add(person1);
        people.add(person2);
        people.add(person3);

        //when
        CelebrityFinderService celebrityFinderService = new CelebrityFinderService();
        PersonWithKnownPeople celebrity = celebrityFinderService.findTheCelebrity(people);

        //then
        assertThat(celebrity).isNotNull();
        assertThat(celebrity.getPersonId()).isEqualTo(3L);
    }

    @Test
    void getCelebrityWithZeroCelebrities() {
        //given
        PersonWithKnownPeople person1 = new PersonWithKnownPeople(1l, "Joe", "Doe");
        person1.addKnownPeople(3l);

        PersonWithKnownPeople person2 = new PersonWithKnownPeople(2l, "Mary", "Jones");

        PersonWithKnownPeople person3 = new PersonWithKnownPeople(3l, "Will", "Smith");

        people.add(person1);
        people.add(person2);
        people.add(person3);

        //when
        CelebrityFinderService celebrityFinderService = new CelebrityFinderService();
        PersonWithKnownPeople celebrity = celebrityFinderService.findTheCelebrity(people);

        //then
        assertThat(celebrity).isNull();
    }

    @Test
    void getCelebrityWithZeroCelebritiesTestCase2() {
        //given
        PersonWithKnownPeople person1 = new PersonWithKnownPeople(1l, "Joe", "Doe");
        PersonWithKnownPeople person2 = new PersonWithKnownPeople(2l ,"Mary", "Jones");
        PersonWithKnownPeople person3 = new PersonWithKnownPeople(3l, "Will", "Smith");

        people.add(person1);
        people.add(person2);
        people.add(person3);

        //when
        CelebrityFinderService celebrityFinderService = new CelebrityFinderService();
        PersonWithKnownPeople celebrity = celebrityFinderService.findTheCelebrity(people);

        //then
        assertThat(celebrity).isNull();
    }

    @Test
    void getCelebrityWithZeroCelebritiesTestCase3NullNames() {
        //given
        PersonWithKnownPeople person1 = new PersonWithKnownPeople();
        PersonWithKnownPeople person2 = new PersonWithKnownPeople(2l, "Mary", "Jones");
        PersonWithKnownPeople person3 = new PersonWithKnownPeople(3l, "Will", "Smith");

        people.add(person1);
        people.add(person2);
        people.add(person3);

        //when
        CelebrityFinderService celebrityFinderService = new CelebrityFinderService();
        PersonWithKnownPeople celebrity = celebrityFinderService.findTheCelebrity(people);

        //then
        assertThat(celebrity).isNull();

    }

    @Test
    void getCelebrityInvalidPeopleList() {
        //given
        people = null;

        //when
        CelebrityFinderService celebrityFinderService = new CelebrityFinderService();
        PersonWithKnownPeople celebrity = celebrityFinderService.findTheCelebrity(people);

        //then
        assertThat(celebrity).isNull();
    }
}
