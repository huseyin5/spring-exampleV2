package com.example.rc.api;

import com.example.rc.model.PersonDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Controller
@RequestMapping("/test")
public class RestClientController {

    private static final String webUrl = "http://host.docker.internal:8083";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping
    public ResponseEntity<List<PersonDto>> getPersonList() {
        ResponseEntity<List> result = restTemplate.getForEntity(webUrl, List.class);
        List<PersonDto> responsebody = result.getBody();
        return ResponseEntity.ok(responsebody);
    }

    @PostMapping
    public ResponseEntity<PersonDto> savePerson(PersonDto personDto) {
        ResponseEntity<PersonDto> result = restTemplate.postForEntity(webUrl, personDto, PersonDto.class);
        PersonDto responsebody = result.getBody();
        return ResponseEntity.ok(responsebody);
    }
}
