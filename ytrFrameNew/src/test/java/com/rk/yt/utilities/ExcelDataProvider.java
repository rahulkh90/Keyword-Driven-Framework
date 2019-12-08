package com.rk.yt.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {

	XSSFWorkbook wb;

	public ExcelDataProvider() {

		File f = new File("./TestData/ExcelData.xlsx");

		try {
			FileInputStream fis = new FileInputStream(f);
			wb = new XSSFWorkbook(fis);
		} catch (Exception e) {

			System.out.println("Unable to read excel" + e.getMessage());
		}
	}

	public String getStringData(String sheetname, int row, int col) {

		return wb.getSheet(sheetname).getRow(row).getCell(col).getStringCellValue();
	}

	
	public double getNumericData(String sheetname, int row, int col) {

		return wb.getSheet(sheetname).getRow(row).getCell(col).getNumericCellValue();
	}
}
