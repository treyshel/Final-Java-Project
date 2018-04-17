package com.example.backend.Controllers;import com.example.backend.Core.Student;



import com.example.backend.Core.Recruiter;
import com.example.backend.Repositories.StudentRepostiory;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class AllStudentsController {
    @CrossOrigin()
    @PostMapping("/AllStudents")
    public ArrayList<Student> returnAllStudents(@RequestBody Student allStudents) {
        return StudentRepostiory.allStudents();
    }
}
