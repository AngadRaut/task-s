package com.example.task.services;

import com.example.task.entities.StudentInfo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface StudentService {
    public StudentInfo saveStudentInfo(StudentInfo studentInfo);
    List<StudentInfo> fetchAllStudents();
    Optional<StudentInfo> findStudentById(Long id);
    void deleteById(Long id);
}
