package com.hoanghung.profilemanage.repository;

import com.hoanghung.profilemanage.entity.Person;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by hxhung on 8/24/2017.
 */

public interface PersonRepository extends CrudRepository<Person, Long> {}
