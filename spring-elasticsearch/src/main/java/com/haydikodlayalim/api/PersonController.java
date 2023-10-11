package com.haydikodlayalim.api;

import com.haydikodlayalim.entity.Person;
import com.haydikodlayalim.repository.PersonRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/person")
public class PersonController {
    private final PersonRepository personRepository;

    @PostConstruct
    public void init() {
        Person person = new Person();
        person.setName("Hüseyin");
        person.setLastName("Mutlu");
        person.setAdress("test");
        person.setDateOfBirth(Calendar.getInstance().getTime());
        person.setId("P0001");
        personRepository.save(person);
    }

    @GetMapping("/{search}")
    public ResponseEntity<List<Person>> getPerson(@PathVariable String search) {
        List<Person> persons = personRepository.findByNameLikeOrLastNameLike(search, search);
        return ResponseEntity.ok(persons);
    }


}
