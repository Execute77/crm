package com.utilities;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;

public class TestDataProvider {

    static XSSFWorkbook wb;
    final String testDataFilePath = "/src/test/resources/TestData.xlsx";

    private void loadTestData(){
        try {
            File file = new File(System.getProperty("user.dir") + testDataFilePath);
            FileInputStream fis = new FileInputStream(file);
            wb = new XSSFWorkbook(fis);
        }catch (Exception e){
            System.out.println("Unable to load test data file - "+e);
        }
    }

    public XSSFWorkbook getWorkbook(){
        if(wb == null)
            loadTestData();
        return wb;
    }

    public String getStringData(String sheetName, int row, int column){
        return getWorkbook().getSheet(sheetName).getRow(row).getCell(column).getStringCellValue();
    }

}
