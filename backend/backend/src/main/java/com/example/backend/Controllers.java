package com.example.backend;


import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class Controllers {
    private String salt;
    @CrossOrigin()
    @PostMapping("/signup")
    public void signup(@RequestBody Student newStudent) {

        StudentRepostiory.insertStudent(
                newStudent.f_name,
                newStudent.l_name,
                newStudent.username,
                newStudent.password,
                newStudent.email
        );
    }
}
