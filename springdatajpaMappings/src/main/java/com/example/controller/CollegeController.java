package com.example.controller;

import com.example.entities.College;
import com.example.service.collegeService.CollegeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/college")
public class CollegeController {
    @Autowired
    private CollegeService collegeService;

    // save college details
    @PostMapping("/addcollege")
    public ResponseEntity<String> saveCollegeDetails(@Valid @RequestBody College college){
        College college1 = this.collegeService.addCollege(college);
        return ResponseEntity.status(HttpStatus.CREATED).body("college details saved successfully!!"+college1);
    }
}
