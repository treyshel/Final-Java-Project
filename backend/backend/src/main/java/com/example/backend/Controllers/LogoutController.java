package com.example.backend.Controllers;

import com.example.backend.Repositories.StudentRepostiory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogoutController {
    @CrossOrigin
    @PostMapping("/logout/{username}")
    public boolean logout(@PathVariable String username) {
        return (StudentRepostiory.byeByeSessionKey(username));
    }
}
