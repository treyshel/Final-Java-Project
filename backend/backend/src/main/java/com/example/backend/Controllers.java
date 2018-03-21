package com.example.backend;


import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class Controllers {
    @Value("${app.salt}")
    private String salt;
    @CrossOrigin()
    @PostMapping("/signup")
    public void signup(@RequestBody Student newStudent) {
//        line 22 hashes the password
        String pw = BCrypt.hashpw(newStudent.password,salt);
        StudentRepostiory.insertStudent(
                newStudent.f_name,
                newStudent.l_name,
                newStudent.username,
                pw,
                newStudent.email
        );
    }
}
