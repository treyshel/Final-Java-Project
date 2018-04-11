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

    String makeSessionKey() {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        String sessionKey = "";
        Random randomString = new Random();
        int randomLength = 5 + randomString.nextInt(5);
        for (int i = 0; i < randomLength; i++) {
            char c = alphabet.charAt(randomString.nextInt(26));
            sessionKey += c;
        }
        return sessionKey;
    }
    @CrossOrigin()
    @PostMapping("/login")
    public Student login(@RequestBody Login existingStudent) {
        String pw = BCrypt.hashpw(existingStudent.p_word,salt);
        String sessionKey = makeSessionKey();
        Student isStudent = StudentRepostiory.StudentExists(
                sessionKey,
                existingStudent.username,
                pw
        );
        if (isStudent != null){
            return isStudent;
        } else {
            return null;
        }
    }
}