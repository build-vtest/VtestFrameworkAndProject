package com.vtest.reusemethods;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelParserUtil {
	private String filePath = null;

	private FileInputStream fis = null;
	private Workbook wb = null;
	private Sheet sh = null;

	public ExcelParserUtil(String filePath, String sheetName) {

		try {

			this.fis = new FileInputStream(filePath);
			this.wb = WorkbookFactory.create(fis);
			this.sh = wb.getSheet(sheetName);
			this.filePath = filePath;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getExcelData(int rowNum, int colNum) throws InvalidFormatException, IOException {

		Row row = sh.getRow(rowNum);
		String data = row.getCell(colNum).getStringCellValue();
		return data;
	}

	public int getRowCount(String sheetName) throws InvalidFormatException, IOException {

		Sheet sh = wb.getSheet(sheetName);
		int rowCount = sh.getLastRowNum() + 1;
		return rowCount;
	}

	public void setExcelData(int rowNum, int colNum, String data) throws IOException {
		FileOutputStream fos = null;
		try {

			Row row = sh.getRow(rowNum);
			Cell cel = row.createCell(colNum);
		
			cel.setCellValue(data);

			fos = new FileOutputStream(this.filePath);
			wb.write(fos);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (fos != null) {
				fos.close();
			}
		}
	}

}
