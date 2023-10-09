package com.haydikodlayalim;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/pet")
public class PetController {
    private List<Pet> petList = new ArrayList<>();


    @PostMapping
    public ResponseEntity<Pet> save(@RequestBody Pet pet) {
        petList.add(pet);
        return ResponseEntity.ok(pet);
    }

    @GetMapping
    public ResponseEntity<List<Pet>> getAll() {
        return ResponseEntity.ok(petList);
    }
}
