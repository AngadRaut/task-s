package com.exel_to_db.services;

import com.exel_to_db.entities.StateInIndia;
import com.exel_to_db.helper.StatesHelper;
import com.exel_to_db.repositories.StateInIndiaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class StateServiceImpl implements StatesService{
    @Autowired
    private StateInIndiaRepo repo;

    @Override
    public List<StateInIndia> getExcelDataAsList() {
        return List.of();
    }

    @Override
    public void addFile(MultipartFile file){
        try {
            List<StateInIndia> state = StatesHelper.saveDataAsList(file.getInputStream());
            this.repo.saveAll(state);
        }catch (IOException e){
           throw new RuntimeException("fail to save excel data : "+e.getMessage());
        }
    }
}
