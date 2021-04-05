package com.mycompany.celebrityapp.service;

import com.mycompany.celebrityapp.domain.Person;
import com.mycompany.celebrityapp.domain.PersonWithKnownPeople;
import lombok.extern.slf4j.Slf4j;

import java.util.*;
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

    public PersonWithKnownPeople findTheCelebrity(List<PersonWithKnownPeople> people) {
        Map<Long, PersonWithKnownPeople> peopleMap = new HashMap<>();
        Map<Long, Long> celebritiesCandidateCountMap = new HashMap<>();
        PersonWithKnownPeople celebrity = null;
        log.info("findTheCelebrity");

        if(people != null){
            for (PersonWithKnownPeople personInList : people) {
                peopleMap.put(personInList.getPersonId(), personInList);
            }

            for (PersonWithKnownPeople personInList : people) {
                for (Long knownPersonId : personInList.getKnowPeople()) {
                    if(peopleMap.get(knownPersonId) != null){
                        Long currentCount = celebritiesCandidateCountMap.get(knownPersonId);
                        if(currentCount == null){
                            currentCount = 0l;
                        }
                        currentCount ++;
                        celebritiesCandidateCountMap.put(knownPersonId, currentCount);
                    }
                }
            }

            for(Long celebrityCandidateId: celebritiesCandidateCountMap.keySet()){
                if(celebritiesCandidateCountMap.get(celebrityCandidateId) == people.size()){
                    celebrity = peopleMap.get(celebrityCandidateId);
                }
            }
        }

        log.info("celebrity found: " + celebrity);
        return celebrity;
    }


}
