package com.example.backend.Controllers;

import com.example.backend.Core.Recruiter;
import com.example.backend.Core.Student;
import com.example.backend.Repositories.RecruiterRepository;
import com.example.backend.Repositories.StudentRepostiory;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class FeedController {
    @CrossOrigin()
    @PostMapping("/student-feed/{username}")
    public Student studentLogin(@PathVariable String username){
        return StudentRepostiory.byUsername(username);
    }

    @CrossOrigin()
    @PostMapping("/recruiter-feed/{username}")
    public Recruiter recruiterLogin(@PathVariable String username) {
        return RecruiterRepository.byUsername(username);
    }

    @CrossOrigin()
    @GetMapping("/allStudents")
    public ArrayList<Student> returnAllStudents() {
        return StudentRepostiory.allStudents();
    }

    @CrossOrigin()
    @GetMapping("/allRecruiters")
    public ArrayList<Recruiter> returnAllRecruiters() {
        return RecruiterRepository.allRecruiters();
    }

    @CrossOrigin()
    @GetMapping("/recruiter-filter-location")
    public ArrayList<Student> recruiterFilterByLocation() {
        return RecruiterRepository.sameLocation();
    }

}
