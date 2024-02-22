package com.example.virtual.plant.store.LoginDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class LoginDto {
    private String userType;
    private  String email;
    private String password;

}
