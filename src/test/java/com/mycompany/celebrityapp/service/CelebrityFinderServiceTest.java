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
        PersonWithKnownPeople person1 = new PersonWithKnownPeople("Joe", "Doe");
        person1.addKnownPeople("Will Smith");

        PersonWithKnownPeople person2 = new PersonWithKnownPeople("Mary", "Jones");
        person2.addKnownPeople("Will Smith");

        PersonWithKnownPeople person3 = new PersonWithKnownPeople("Will", "Smith");

        people.add(person1);
        people.add(person2);
        people.add(person3);

        //when
        CelebrityFinderService celebrityFinderService = new CelebrityFinderService();
        List<PersonWithKnownPeople> celebrities = celebrityFinderService.findCelebrities(people);

        //then
        assertThat(celebrities).isNotNull()
                .contains(person3)
                .size().isEqualTo(1);
    }

    @Test
    void getCelebrityWithTwoCelebrities() {
        //given
        PersonWithKnownPeople person1 = new PersonWithKnownPeople("Joe", "Doe");
        person1.addKnownPeople("Will Smith");
        person1.addKnownPeople("Kurt Cobain");

        PersonWithKnownPeople person2 = new PersonWithKnownPeople("Kurt", "Cobain");
        person2.addKnownPeople("Will Smith");

        PersonWithKnownPeople person3 = new PersonWithKnownPeople("Will", "Smith");
        person3.addKnownPeople("Kurt Cobain");

        people.add(person1);
        people.add(person2);
        people.add(person3);

        //when
        CelebrityFinderService celebrityFinderService = new CelebrityFinderService();
        List<PersonWithKnownPeople> celebrities = celebrityFinderService.findCelebrities(people);

        //then
        assertThat(celebrities).isNotNull()
                .isNotEmpty()
                .size().isEqualTo(2);
    }

    @Test
    void getCelebrityWithZeroCelebrities() {
        //given
        PersonWithKnownPeople person1 = new PersonWithKnownPeople("Joe", "Doe");
        person1.addKnownPeople("Will Smith");

        PersonWithKnownPeople person2 = new PersonWithKnownPeople("Mary", "Jones");

        PersonWithKnownPeople person3 = new PersonWithKnownPeople("Will", "Smith");

        people.add(person1);
        people.add(person2);
        people.add(person3);

        //when
        CelebrityFinderService celebrityFinderService = new CelebrityFinderService();
        List<PersonWithKnownPeople> celebrities = celebrityFinderService.findCelebrities(people);

        //then
        assertThat(celebrities).isNotNull()
                .isEmpty();
    }

    @Test
    void getCelebrityWithZeroCelebritiesTestCase2() {
        //given
        PersonWithKnownPeople person1 = new PersonWithKnownPeople("Joe", "Doe");
        PersonWithKnownPeople person2 = new PersonWithKnownPeople("Mary", "Jones");
        PersonWithKnownPeople person3 = new PersonWithKnownPeople("Will", "Smith");

        people.add(person1);
        people.add(person2);
        people.add(person3);

        //when
        CelebrityFinderService celebrityFinderService = new CelebrityFinderService();
        List<PersonWithKnownPeople> celebrities = celebrityFinderService.findCelebrities(people);

        //then
        assertThat(celebrities).isNotNull()
                .isEmpty();
    }

    @Test
    void getCelebrityWithZeroCelebritiesTestCase3NullNames() {
        //given
        PersonWithKnownPeople person1 = new PersonWithKnownPeople();
        PersonWithKnownPeople person2 = new PersonWithKnownPeople("Mary", "Jones");
        PersonWithKnownPeople person3 = new PersonWithKnownPeople("Will", "Smith");

        people.add(person1);
        people.add(person2);
        people.add(person3);

        //when
        CelebrityFinderService celebrityFinderService = new CelebrityFinderService();
        List<PersonWithKnownPeople> celebrities = celebrityFinderService.findCelebrities(people);

        //then
        assertThat(celebrities).isNotNull()
                .isEmpty();
    }

    @Test
    void getCelebrityInvalidPeopleList() {
        //given
        people = null;

        //when
        CelebrityFinderService celebrityFinderService = new CelebrityFinderService();
        List<PersonWithKnownPeople> celebrities = celebrityFinderService.findCelebrities(people);

        //then
        assertThat(celebrities).isNotNull()
                .isEmpty();
    }
}
