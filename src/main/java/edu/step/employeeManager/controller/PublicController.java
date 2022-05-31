package edu.step.employeeManager.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:8081/")
public class PublicController {

    @GetMapping("/api/public/info")
    public ResponseEntity<String> info(){
        return ResponseEntity.ok("Welcome to the employee manager. Please login to continue");
    }
}
