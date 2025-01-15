package com.example.controller;

import com.example.entities.Student;
import com.example.service.StudentService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    private static final Logger logger = LoggerFactory.getLogger(StudentController.class);

    // method to create the new student info
    @PostMapping("/addstudent")
    public ResponseEntity<Student> saveStudentInfo(@Valid @RequestBody Student student){
        Student student1 = this.studentService.saveStudent(student);
        logger.info("new student created in the database..."+student1);
        return ResponseEntity.status(HttpStatus.CREATED).body(student1);
//      201 created => The request succeeded, and a new resource was created as a result. This is typically the response sent after POST requests, or some PUT requests.
    }
}
