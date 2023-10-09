package com.haydikodlayalim.api;

import com.haydikodlayalim.entity.User;
import com.haydikodlayalim.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserApi {
    @Autowired
    private UserRepository userRepository;

    @PostConstruct
    private void init() {
        User user = new User();
        user.setName("Hüseyin");
        user.setLastName("Mutlu");
        userRepository.save(user);
    }

    @PostMapping
    public ResponseEntity<User> save(@RequestBody User user) {
        return ResponseEntity.ok(userRepository.save(user));
    }

    @GetMapping
    public ResponseEntity<List<User>> getAll() {
        return ResponseEntity.ok(userRepository.findAll());
    }
}
