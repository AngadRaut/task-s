package com.exel_to_db.controller;

import com.exel_to_db.helper.StatesHelper;
import com.exel_to_db.services.StatesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/states")
public class StatesController {

    @Autowired
    private StatesService statesService;

    // controller to save the file
    @PostMapping("/addxml_file")
    public ResponseEntity<String> uploadFile(@RequestParam("states_info") MultipartFile file){

        if (StatesHelper.checkFormat(file))
        {
            try
            {
                this.statesService.addFile(file);
            }
            catch (IOException e)
            {
                e.printStackTrace();
                throw new RuntimeException("fail to save excel data : "+e.getMessage());
            }
            return ResponseEntity.status(HttpStatus.CREATED).body("File uploaded successfully!!");
        }
        else
        {
            return ResponseEntity.status(HttpStatus.UNSUPPORTED_MEDIA_TYPE).body("The file is not in the expected Excel format.");
        }
    }
}
