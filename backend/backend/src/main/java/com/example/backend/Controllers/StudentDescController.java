package com.example.backend.Controllers;


import com.example.backend.Core.StudentDesc;
import com.example.backend.Repositories.StudentDescRepository;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentDescController {
    @CrossOrigin()
    @PostMapping("/studentDesc")
    public StudentDesc description(@RequestBody StudentDesc newStudent) {
        return StudentDescRepository.insertStudentDesc(
                newStudent.student_id,
                newStudent.programming_langs,
                newStudent.academics,
                newStudent.desired_location
        );
    }
}
