package com.mycompany.celebrityapp.service;

import com.mycompany.celebrityapp.domain.PersonWithKnownPeople;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


/**
 * The Class helps to find celebrities among a list of people
 *
 * @author Renzo Corzo
 * @version 1.0
 * @since 2021-03-31
 */

@Slf4j
public class CelebrityFinderService {

    public List<PersonWithKnownPeople> findCelebrities(List<PersonWithKnownPeople> people) {
        log.debug("findCelebrities :: people: " + people);
        List<PersonWithKnownPeople> celebrities = new ArrayList<>();

        if(people != null) {
            for (int i = 0; i < people.size(); i++) {
                int count = 0;
                PersonWithKnownPeople foundCelebrity = findCelebrity(people.get(i), people);
                if (foundCelebrity != null) {
                    celebrities.add(foundCelebrity);
                }
            }
        }

        log.info("celebrities found: " + celebrities);
        return celebrities;
    }

    private PersonWithKnownPeople findCelebrity(PersonWithKnownPeople celebrityCandidate, List<PersonWithKnownPeople> people) {

        log.debug("isKnownPerson :: celebrityCandidate: " + celebrityCandidate);

        List<PersonWithKnownPeople> filteredPeople = people.stream().filter(person -> person != celebrityCandidate).collect(Collectors.toList());

        int count = 0;
        for (PersonWithKnownPeople personInList : filteredPeople) {
            for (String knownPerson : personInList.getKnowPeople()) {
                if (knownPerson != null &&
                        celebrityCandidate.getFirstName() != null &&
                        celebrityCandidate.getLastName() != null &&
                        (knownPerson.contains(celebrityCandidate.getFirstName()) &&
                                knownPerson.contains(celebrityCandidate.getLastName()))) {
                    count++;
                }
            }
            if (count == filteredPeople.size()) {
                return celebrityCandidate;
            }

        }
        return null;
    }
}
