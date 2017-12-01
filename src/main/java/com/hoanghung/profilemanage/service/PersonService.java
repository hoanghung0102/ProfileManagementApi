package com.hoanghung.profilemanage.service;

import com.hoanghung.profilemanage.entity.Person;
import org.springframework.stereotype.Service;

@Service
public interface PersonService {
    Person getPersonById(Long id);
}
