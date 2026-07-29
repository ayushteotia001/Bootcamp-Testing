package com.saucedemo.utility;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {

    XSSFWorkbook workbook;
    XSSFSheet sheet;

    public ExcelDataProvider() {

        try {

            File src = new File("./TestData/LoginData.xlsx");

            FileInputStream fis = new FileInputStream(src);

            workbook = new XSSFWorkbook(fis);

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    public String getStringData(String sheetName, int row, int col) {

        return workbook.getSheet(sheetName)
                .getRow(row)
                .getCell(col)
                .getStringCellValue();

    }
}
