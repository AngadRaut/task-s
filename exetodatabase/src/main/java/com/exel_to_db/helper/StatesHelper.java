package com.exel_to_db.helper;

import com.exel_to_db.entities.StateInIndia;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StatesHelper {

    // method to check where the file is in excel format or not
    public static boolean checkFormat(MultipartFile file) {
        String string = file.getContentType();
        if (string.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")) {
            return true;
        } else {
            return false;
        }
    }

    // method to save the data in the list format
    public static List<StateInIndia> saveDataAsList(InputStream inputStream) {
        // create an arrayList
        List<StateInIndia> stateInIndiaList = new ArrayList<>();

        try {
//            This is the first object for reading or writing a workbook.
            XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
            Sheet sheet = workbook.getSheet("states_info");
            int row = 0;
            Iterator<Row> itr = sheet.iterator();

            while(itr.hasNext()){
                StateInIndia state = new StateInIndia();
                Row row1 = itr.next();
                if(row==0){
                    row++;
                    continue;
                }
                Iterator<Cell> cell =  row1.iterator();
                int cId = 0 ;
                while(cell.hasNext()){
                    Cell cell1 = cell.next();
                    switch (cId){
                        case 0:
                            state.setSr_no((int)cell1.getNumericCellValue());
                            break;
                        case 1:
                            state.setState((String) cell1.getStringCellValue());
                            break;
                        case 2:
                            state.setIso((String) cell1.getStringCellValue());
                            break;
                        case 3:
                            state.setCapital((String) cell1.getStringCellValue());
                            break;
                        case 4:
                            state.setLargestCity((String) cell1.getStringCellValue());
                            break;
                        case 5:
                            state.setStatehood((String) cell1.getStringCellValue());
                            break;
                        case 6:
                            state.setPopulation_2011(Long.valueOf(cell1.getStringCellValue()));
                            break;
                        case 7:
                            state.setArea_km2(Long.valueOf(cell1.getStringCellValue()));
                            break;
                        case 8:
                            state.setOfficialLanguages((String) cell1.getStringCellValue());
                            break;
                        case 9:
                            state.setAdditionalOfficialLanguages((String) cell1.getStringCellValue());
                            break;
                        case 10:
                            state.setVehicleCode((String) cell1.getStringCellValue());
                            break;
                        default:
                            break;
                    }
                    cId++;
                }
                stateInIndiaList.add(state);
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("fail to save excel data : "+e.getMessage());
        }
        return stateInIndiaList;
    }
}
