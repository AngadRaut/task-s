package com.example.task.controllers;

import com.example.task.customExceptions.StudentNotFoundException;
import com.example.task.entities.StudentInfo;
import com.example.task.services.StudentService;
import com.example.task.services.StudentServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    // handler for creating/saving new student details
    @PutMapping("/create")
    public ResponseEntity<StudentInfo> saveStudent(@Valid @RequestBody StudentInfo studentInfo){
        StudentInfo studentInfo1 = this.studentService.saveStudentInfo(studentInfo);
        return ResponseEntity.status(HttpStatus.CREATED).body(studentInfo1);
    }

    public void add(){
        List<String> stringArrayList = Arrays.asList("satysm","nana");
    }

    // handler fro showing all students information
    @GetMapping("/showAllStudents")
    public ResponseEntity<List<StudentInfo>> getAllStudents(){
        List<StudentInfo> allStudents = this.studentService.fetchAllStudents();
        return ResponseEntity.status(HttpStatus.FOUND).body(allStudents);
    }

    // handler for finding student by id
    @GetMapping("/findStudent/{id}")
    public ResponseEntity<Optional<StudentInfo>> findStudentById(@PathVariable("id") Long id){
        Optional<StudentInfo> student = this.studentService.findStudentById(id);
        return ResponseEntity.status(HttpStatus.FOUND).body(student);
    }

    // delete the student information
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteStudentById(@PathVariable("id") Long id){
      this.studentService.deleteById(id);
      return ResponseEntity.status(HttpStatus.OK)
              .body("student details with "+id+" is deleted successfully.");
    }

    // exception handling handler
    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<String> exceptionHandler(StudentNotFoundException exception){
        return new ResponseEntity<>(exception.getMessage(),HttpStatus.NOT_FOUND);
    }
}