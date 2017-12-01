package com.hoanghung.profilemanage.repository;

import com.hoanghung.profilemanage.entity.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by hxhung on 8/24/2017.
 */
@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {}
