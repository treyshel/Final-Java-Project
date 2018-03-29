package com.example.backend.Controllers;

import com.example.backend.Core.Login;
import com.example.backend.Core.Student;
import com.example.backend.Repositories.StudentRepostiory;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@RestController
public class LoginController {
    @Value("${app.salt}")
    private String salt;
    @CrossOrigin()
    @PostMapping("/login")
    public Student login(@RequestBody Login existingStudent) {

        String pw = BCrypt.hashpw(existingStudent.password,salt);
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        String sessionKey = "";
        Random randomString = new Random();
        int randomLength = 5 + randomString.nextInt(5);
        for (int i = 0; i < randomLength; i++) {
            char c = alphabet.charAt(randomString.nextInt(26));
            sessionKey += c;
        }
        Student isStudent = StudentRepostiory.existingMember(
                sessionKey,
                existingStudent.username,
                pw
        );

        if (isStudent != null){
            return isStudent;
        }else {
            System.out.println("JSON IS WRONG");
            return null;
        }
    }
}