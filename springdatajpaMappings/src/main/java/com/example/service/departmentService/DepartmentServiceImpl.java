package com.example.service.departmentService;

import com.example.entities.Department;
import com.example.repo.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService{
    @Autowired
    private DepartmentRepository departmentRepository;
    @Override
    public Department addDept(Department department) {
        return this.departmentRepository.save(department);
    }
}
