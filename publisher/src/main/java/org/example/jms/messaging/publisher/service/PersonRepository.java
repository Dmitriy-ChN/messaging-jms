package org.example.jms.messaging.publisher.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.jms.messaging.domain.Person;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.Optional;
import java.util.Set;

@Service
public class PersonRepository {
    private final Set<Person> persons;

    public PersonRepository() throws IOException {
        var mapper = new ObjectMapper();
        persons = mapper.readValue(new File("publisher/src/main/resources/records.json"), new TypeReference<>() {
        });
    }

    public Optional<Person> getRecord(String code) {
        return persons.stream()
                .filter(person -> person.getCode().equals(code))
                .findFirst();
    }
}
