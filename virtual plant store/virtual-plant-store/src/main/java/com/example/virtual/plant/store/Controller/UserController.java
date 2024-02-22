package com.example.virtual.plant.store.Controller;

import com.example.virtual.plant.store.entity.User;
import com.example.virtual.plant.store.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")

public class UserController {

    @Autowired
    public UserRepo userRepo;

    @PostMapping("/addUser")
    public ResponseEntity<?> addUser(@RequestBody User obj){
        userRepo.save(obj);
        return new ResponseEntity<>("user added", HttpStatus.OK);
    }
}
