package com.hoanghung.profilemanage.service;

import com.hoanghung.profilemanage.entity.Person;
import com.hoanghung.profilemanage.repository.PersonRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@JdbcTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.ANY)
public class PersonServiceTest {

    private PersonRepository personRepository;
    private PersonService personService;

    @Before
    public void setUp() {
        personRepository = Mockito.mock(PersonRepository.class);
        personService = new PersonServiceImpl();
    }

    @Test
    public void testGetPersonInfo() throws Exception {
        Person person = personService.getPersonById(1l);
        assertThat(person.getId()).isEqualTo(1l);
        assertThat(person.getCity()).isEqualTo("Da Nang");
        assertThat(person.getName()).isEqualTo("Hung");
    }
}
