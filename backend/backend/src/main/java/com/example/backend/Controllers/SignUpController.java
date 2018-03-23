package com.example.backend.Controllers;


import com.example.backend.Core.Student;
import com.example.backend.Repositories.StudentRepostiory;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Random;

@RestController
public class SignUpController {
    @Value("${app.salt}")
    private String salt;
    @CrossOrigin()
    @PostMapping("/signup")
    public Student signup(@RequestBody Student newStudent) {
//        line 24 hashes the password and assigns it to "pw"
        String pw = BCrypt.hashpw(newStudent.p_word,salt);
        // lines 27-33 create a session key
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        String sessionKey = "";
        Random randomString = new Random();
        int randomLength = 5 + randomString.nextInt(5);
        for (int i = 0; i < randomLength; i++) {
            char c = alphabet.charAt(randomString.nextInt(26));
            sessionKey += c;
        }
        System.out.println(newStudent);
        return StudentRepostiory.insertStudent(
                newStudent.f_name,
                newStudent.l_name,
                sessionKey,
                newStudent.username,
                pw,
                newStudent.email
        );
    }
}
