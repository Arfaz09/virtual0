package com.example.virtual.plant.store.Controller;


import com.example.virtual.plant.store.LoginDto.LoginDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.virtual.plant.store.repository.AdminRepo;
import com.example.virtual.plant.store.repository.UserRepo;

@RestController
@CrossOrigin("*")
public class LoginController {
    @Autowired
    public AdminRepo adminRepo;

    @Autowired
    public UserRepo userRepo;

    @PostMapping("/LoginVerify")
    public ResponseEntity<?> loginVerify(@RequestBody LoginDto obj) {
        if (obj.getUserType().equals("admin")) {
            var admin = adminRepo.findById(obj.getEmail()).orElseThrow(() -> new RuntimeException("Admin not found"));
            if (admin.getPassword().equals(obj.getPassword())) {
                return new ResponseEntity<>("Login successfull", HttpStatus.OK);
            } else {
                throw new RuntimeException("invalid password");
            }
        } else if (obj.getUserType().equalsIgnoreCase("USER")) {
            var user = userRepo.findByEmail(obj.getEmail()).orElseThrow(() -> new RuntimeException("user not found"));
            if (user.getPassword().equals(obj.getPassword())) {
                return new ResponseEntity<>("Login successfull", HttpStatus.OK);
            } else {
                throw new RuntimeException("Invalid password");
            }
        } else {

            throw new RuntimeException("Invalid user type");
        }
    }
}