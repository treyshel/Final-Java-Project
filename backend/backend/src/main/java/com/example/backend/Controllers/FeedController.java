package com.example.backend.Controllers;

import com.example.backend.Core.Recruiter;
import com.example.backend.Core.Student;
import com.example.backend.Repositories.RecruiterRepository;
import com.example.backend.Repositories.StudentRepostiory;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class FeedController {

    //////// urls for showing feed for both ////////

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

    //////// urls for returning all students or all recruiters ////////

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

    //////// urls for filtering by same location input ////////

    @CrossOrigin()
    @GetMapping("/student-filter-location")
    public ArrayList<Recruiter> studentFilterByLocation() {
        return StudentRepostiory.sameLocation();
    }

    @CrossOrigin()
    @GetMapping("/recruiter-filter-location")
    public ArrayList<Student> recruiterFilterByLocation() {
        return RecruiterRepository.sameLocation();
    }

    //////// urls for filtering by same position level input ////////

    @CrossOrigin()
    @GetMapping("/student-filter-level")
    public ArrayList<Recruiter> studentFilterByPositionLevel() {
        return StudentRepostiory.positionLevel();
    }

    @CrossOrigin()
    @GetMapping("/recruiter-filter-level")
    public ArrayList<Student> recruiterFilterByPositionLevel() {
        return RecruiterRepository.positionLevel();
    }

    //////// urls for filtering by same language input ////////

    @CrossOrigin()
    @GetMapping("/student-filter-language")
    public ArrayList<Recruiter> studentFilterByLanguages() {
        return StudentRepostiory.sameLanguage();
    }

    @CrossOrigin()
    @GetMapping("/recruiter-filter-language")
    public ArrayList<Student> recruiterFilterByLanguages() {
        return RecruiterRepository.sameLanguage();
    }

}
