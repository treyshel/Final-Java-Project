package com.example.backend.Controllers;

import com.example.backend.Core.Login;
import com.example.backend.Core.Recruiter;
import com.example.backend.Core.Student;
import com.example.backend.Repositories.RecruiterRepository;
import com.example.backend.Repositories.StudentRepostiory;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Random;

@RestController
public class AccountController {
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
    @PostMapping("/student-login")
    public Student studentLogin(@RequestBody Login existingStudent) {
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

    @CrossOrigin()
    @PostMapping("/recruiter-login")
    public Recruiter recruiterLogin(@RequestBody Login existingRecruiter) {
        String pw = BCrypt.hashpw(existingRecruiter.p_word, salt);
        String sessionKey = makeSessionKey();
        Recruiter isRecruiter = RecruiterRepository.RecruiterExists(
                sessionKey,
                existingRecruiter.username,
                pw
        );
        if (isRecruiter != null) {
            return isRecruiter;
        } else {
            return null;
        }
    }

    @CrossOrigin()
    @PostMapping("/student-signup")
    public Student studentSignup(@RequestBody Student newStudent) {
        String pw = BCrypt.hashpw(newStudent.p_word, salt);
        String sessionKey = makeSessionKey();
        return StudentRepostiory.insertStudent(
                newStudent.f_name,
                newStudent.l_name,
                sessionKey,
                newStudent.username,
                pw,
                newStudent.email,
                newStudent.programming_langs,
                newStudent.desired_location,
                newStudent.linkedin_url,
                newStudent.resume_url,
                newStudent.github_url,
                newStudent.portfolio_url
        );
    }

    @CrossOrigin()
    @PostMapping("/recruiter-signup")
    public Recruiter recruiterSignup(@RequestBody Recruiter newRecruiter) {
        String pw = BCrypt.hashpw(newRecruiter.p_word, salt);
        String sessionKey = makeSessionKey();
        return RecruiterRepository.insertRecruiter(
                newRecruiter.f_name,
                newRecruiter.l_name,
                newRecruiter.title,
                sessionKey,
                newRecruiter.username,
                pw,
                newRecruiter.email,
                newRecruiter.position_level,
                newRecruiter.company_name,
                newRecruiter.company_location,
                newRecruiter.langs_used,
                newRecruiter.website_url
        );
    }

    @CrossOrigin()
    @PostMapping("/student-deleteAccount/{username}")
    public boolean studentDeleteAccount(@PathVariable String username) {
        return StudentRepostiory.deleteAccount(username);
    }

    @CrossOrigin()
    @PostMapping("/recruiter-delete-account/{username}")
    public boolean recruiterDeleteAccount(@PathVariable String username) {
        return RecruiterRepository.deleteAccount(username);
    }


    @CrossOrigin()
    @PostMapping("/student-logout/{username}")
    public boolean studentLogout(@PathVariable String username) {
        return StudentRepostiory.byeByeSessionKey(username);
    }

    @CrossOrigin()
    @GetMapping("/recruiter-logout/{username}")
    public ArrayList<Student> recruiterLogout() {
        return RecruiterRepository.sameLocation();
    }

}