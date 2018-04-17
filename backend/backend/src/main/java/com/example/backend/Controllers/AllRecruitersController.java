package com.example.backend.Controllers;


import com.example.backend.Core.Recruiter;
import com.example.backend.Repositories.RecruiterRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class AllRecruitersController {
    @CrossOrigin
    @PostMapping("/allRecruiters")
    public ArrayList<Recruiter> returnAllRecruiters(@RequestBody Recruiter allRecruiters) {
        return RecruiterRepository.allRecruiters();
    }
}
