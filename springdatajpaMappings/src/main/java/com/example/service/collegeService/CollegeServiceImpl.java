package com.example.service.collegeService;

import com.example.entities.College;
import com.example.repo.CollegeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CollegeServiceImpl implements CollegeService {
    @Autowired
    private CollegeRepository collegeRepository;

    @Override
    public College addCollege(College college) {
        return this.collegeRepository.save(college);
    }
}
