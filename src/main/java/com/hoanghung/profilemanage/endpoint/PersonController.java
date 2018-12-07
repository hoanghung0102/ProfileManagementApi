package com.hoanghung.profilemanage.endpoint;

import com.hoanghung.profilemanage.entity.Person;
import com.hoanghung.profilemanage.entity.User;
import com.hoanghung.profilemanage.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by hxhung on 8/24/2017.
 */
@RestController
@RequestMapping("/profile-management")
@CrossOrigin()
public class PersonController extends BaseController {

    @Autowired
    private PersonService personService;

    @Autowired
    private UserDetailsService userService;

    @PostMapping("/login")
    public ResponseEntity<Object> getPerson(@RequestBody User user) {
        try {
            UserDetails usd = userService.loadUserByUsername(user.getUsername());
            return ResponseEntity.ok(usd);
        } catch (UsernameNotFoundException ex) {
            return ResponseEntity.ok(ex.getMessage());
        }
    }

    @GetMapping("/person")
    public ResponseEntity<Person> getPerson(@RequestParam(value = "id", required = false) Long id) {
        return ResponseEntity.ok(personService.getPersonById(id));
    }

    @GetMapping("/person/all")
    public ResponseEntity<List<Person>> getPerson() {
        return ResponseEntity.ok(personService.getAllPerson());
    }

    @DeleteMapping("/person/delete")
    public void deletePersonById(@RequestParam(value = "id") Long id) {
        personService.detelePersonById(id);
    }

    @PostMapping("/person/save")
    public void addNewPerson(@RequestBody Person person) {
        personService.addNewPerson(person);
    }

    @PatchMapping("/person/update")
    public void updatePerson(@RequestBody Person person) {
        personService.addNewPerson(person);
    }
}
