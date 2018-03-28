package com.example.backend.Controllers;

import com.example.backend.Core.Student;
import com.example.backend.Repositories.StudentRepostiory;
import org.springframework.web.bind.annotation.*;

@RestController
public class FeedController {
    @CrossOrigin()
    @PostMapping("/feed/{username}")
    public Student login(@PathVariable String username){
        return StudentRepostiory.byUsername(username);
    }
}
