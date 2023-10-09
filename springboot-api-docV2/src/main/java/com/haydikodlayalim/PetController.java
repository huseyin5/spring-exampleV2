package com.haydikodlayalim;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import jakarta.annotation.PostConstruct;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/pet")
@Api(value = "my pet obj doc")
public class PetController {

    private List<Pet> petList = new ArrayList<>();

    @PostConstruct
    public void init() {
        petList.add(new Pet(1, "Test pet", new Date()));
    }

    @PostMapping
    @ApiOperation(value = "new pet add method", notes = "new pet added methods")
    public ResponseEntity<Pet> save(@RequestBody @ApiParam(value = "animals") Pet pet) {
        petList.add(pet);
        return ResponseEntity.ok(pet);
    }

    @GetMapping
    @ApiOperation(value = "pet list methods", notes = "get all methods")
    public ResponseEntity<List<Pet>> getAll() {
        return ResponseEntity.ok(petList);
    }
}
