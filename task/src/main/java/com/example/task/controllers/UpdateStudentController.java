package com.example.task.controllers;

import com.example.task.customExceptions.StudentNotFoundException;
import com.example.task.entities.StudentInfo;
import com.example.task.entities.UpdatedStudentInfo;
import com.example.task.services.StudentService;
import com.example.task.services.UpdateStudentInfoService;
import com.example.task.services.UpdateStudentInfoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/updateStudent")
public class UpdateStudentController {

    @Autowired
    private UpdateStudentInfoService updateStudentInfoService;

    @Autowired
    private StudentService studentService;

   // update the information of student
    @PutMapping("update/{id}")
    public ResponseEntity<UpdatedStudentInfo> update(@PathVariable("id") Long id
                                                 , @RequestBody UpdatedStudentInfo updatedStudentInfo){
        UpdatedStudentInfo updatedStudentInfo1 = this.updateStudentInfoService.updateStudent(id,updatedStudentInfo);
        return ResponseEntity.status(HttpStatus.CREATED).body(updatedStudentInfo1);
    }
}
