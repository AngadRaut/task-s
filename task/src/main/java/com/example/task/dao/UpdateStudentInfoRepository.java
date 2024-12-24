package com.example.task.dao;

import com.example.task.entities.UpdatedStudentInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpdateStudentInfoRepository extends JpaRepository<UpdatedStudentInfo,Long> {

}
