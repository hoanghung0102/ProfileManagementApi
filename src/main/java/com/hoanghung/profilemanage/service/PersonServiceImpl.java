package com.hoanghung.profilemanage.service;

import com.hoanghung.profilemanage.entity.Person;
import com.hoanghung.profilemanage.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;
import java.util.List;

@Transactional
@Service
public class PersonServiceImpl implements PersonService {

    @PersistenceContext
    private EntityManager em;

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

    @Override
    public void addNewPerson(Person person) {
        personRepository.save(person);
    }

    @Override
    public void updatePerson(Person person) {
        CriteriaBuilder cb = this.em.getCriteriaBuilder();

        // create update
        CriteriaUpdate<Person> update = cb.createCriteriaUpdate(Person.class);
        // set the root class
        Root e = update.from(Person.class);
        // set update and where clause
        update.set("name", person.getName());
        update.set("city", person.getCity());
        update.set("address", person.getAddress());
        update.set("sex", person.isSex());
        update.where(cb.equal(e.get("id"), person.getId()));

        // perform update
        this.em.createQuery(update).executeUpdate();
    }
}
