package com.example.backend.Controllers;

import com.example.backend.Core.Student;
import com.example.backend.Repositories.StudentRepostiory;
import org.springframework.web.bind.annotation.*;

@RestController
public class DeleteAccountController {
    @CrossOrigin()
    @PostMapping("/deleteAccount/{username}")
    public boolean deleteAccount(@PathVariable String username) {
        return StudentRepostiory.deleteAccount(username);
    }

}
