package com.hoanghung.profilemanage.endpoint;

import com.hoanghung.profilemanage.entity.Person;
import com.hoanghung.profilemanage.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by hxhung on 8/24/2017.
 */
@RestController
@RequestMapping("/profile-management")
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @GetMapping("/person")
    public ResponseEntity<Person> getPerson() {

        Person person = personRepository.findOne(1L);

        return ResponseEntity.ok(person);
    }
}
