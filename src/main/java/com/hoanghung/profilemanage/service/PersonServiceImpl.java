package com.hoanghung.profilemanage.service;

import com.hoanghung.profilemanage.entity.Person;
import com.hoanghung.profilemanage.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public Person getPersonById(Long id) {
        return personRepository.findOne(id);
    }

    @Override
    public List<Person> getAllPerson() {
        return (List<Person>) personRepository.findAll();
    }

    @Override
    public void detelePersonById(Long id) {
        personRepository.delete(id);
    }
}
