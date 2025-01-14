package com.exel_to_db.services;


import com.exel_to_db.entities.StateInIndia;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface StatesService {
   public List<StateInIndia> getExcelDataAsList();
   public void addFile(MultipartFile file) throws IOException;
}
