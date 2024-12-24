package com.example.task.dao;

import com.example.task.entities.StudentInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//@Repository
public interface StudentRepository extends JpaRepository<StudentInfo,Long> {

}
