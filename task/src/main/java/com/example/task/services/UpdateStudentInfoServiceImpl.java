package com.example.task.services;


import com.example.task.customExceptions.StudentNotFoundException;
import com.example.task.dao.StudentRepository;
import com.example.task.dao.UpdateStudentInfoRepository;
import com.example.task.entities.StudentInfo;
import com.example.task.entities.UpdatedStudentInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class UpdateStudentInfoServiceImpl implements UpdateStudentInfoService{

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private UpdateStudentInfoRepository updateStudentRepo;

    @Override
    public UpdatedStudentInfo updateStudent(Long id,UpdatedStudentInfo updateStudent) {
        UpdatedStudentInfo studentInfo2 =null;

        UpdatedStudentInfo studentInfo = new UpdatedStudentInfo();
        Optional<StudentInfo> std = this.studentRepository.findById(id);// old object

        if(std.isPresent()){
            StudentInfo studentInfo1 = std.get();
           if(studentInfo1.getId()==id){
               studentInfo.setOldId(studentInfo1.getId());
               studentInfo.setOldName(studentInfo1.getName());
               studentInfo.setOldEmail(studentInfo1.getStudentEmail());

               studentInfo.setUpdatedName(updateStudent.getUpdatedName());
               studentInfo.setUpdatedStudentEmail(updateStudent.getUpdatedStudentEmail());
               studentInfo.setUpdateAt(new Date());
                studentInfo2 = updateStudentRepo.save(studentInfo);
           }
        }
        else {
            throw new StudentNotFoundException("student with "+id+" is not present in database");
        }
        return studentInfo2;
    }
}
