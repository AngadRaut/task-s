package com.example.task.services;

import com.example.task.entities.UpdatedStudentInfo;

public interface UpdateStudentInfoService {
    UpdatedStudentInfo updateStudent(Long id,UpdatedStudentInfo updateStudent);
}
