package com.hoanghung.profilemanage.service;

import com.hoanghung.profilemanage.entity.Person;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PersonService {
    Person getPersonById(Long id);
    List<Person> getAllPerson();
    void detelePersonById(Long id);
    void addNewPerson(Person person);
}
