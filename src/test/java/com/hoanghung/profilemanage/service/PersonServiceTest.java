package com.hoanghung.profilemanage.service;

import com.hoanghung.profilemanage.entity.Person;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PersonServiceTest {

    // private PersonRepository personRepository;

    @Autowired
    private PersonService personService;

    @Before
    public void setUp() {
        // personRepository = Mockito.mock(PersonRepository.class);
    }

    @Test
    public void testGetPersonInfo() throws Exception {
        Person person = personService.getPersonById(1l);
        assertThat(person.getId()).isEqualTo(1l);
        assertThat(person.getCity()).isEqualTo("Da Nang");
        assertThat(person.getName()).isEqualTo("Hung");
    }
}
