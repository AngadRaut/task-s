package com.example.task.services;

import com.example.task.customExceptions.StudentNotFoundException;
import com.example.task.dao.StudentRepository;
import com.example.task.entities.StudentInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService{
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public StudentInfo saveStudentInfo(StudentInfo studentInfo) {
        this.studentRepository.save(studentInfo);
        return studentInfo;
    }

    @Override
    public List<StudentInfo> fetchAllStudents() {
        return this.studentRepository.findAll();
    }

    @Override
    public Optional<StudentInfo> findStudentById(Long id) {
        Optional<StudentInfo> studentInfo = this.studentRepository.findById(id);
        if(studentInfo.isPresent()){
            StudentInfo studentInfo1 = studentInfo.get();
            return Optional.of(studentInfo1);
        }else {
            throw new StudentNotFoundException("student with "+id+" is not found in the record...");
        }
    }

    @Override
    public void deleteById(Long id) {
        Optional<StudentInfo> student = this.studentRepository.findById(id);
        if(student.isPresent()){
            this.studentRepository.deleteById(id);
        }
        else {
            throw new StudentNotFoundException("student with "+id+" is not found in the record...");
        }
    }
}