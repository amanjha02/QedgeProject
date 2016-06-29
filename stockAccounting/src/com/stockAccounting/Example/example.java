package com.stockAccounting.Example;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class example{
	public static String path="D:\\workspace\\stockAccounting\\src\\com\\stockAccounting\\Testdata";
	public static void main(String[] args) throws IOException {
		example exp=new example();
		exp.readexcelfile("testdata.xlsx", "sheet1");
	}
public void readexcelfile(String filename,String sheetname) throws IOException{
	String excelpath=path+"\\"+filename;
	FileInputStream fis=new FileInputStream(excelpath);
	XSSFWorkbook wb=new XSSFWorkbook(fis);
	XSSFSheet ws=wb.getSheet(sheetname);
	int row=ws.getLastRowNum();
	System.out.println(row);
	for (int i = 1; i <= row; i++)
	{
		int cc=ws.getRow(i).getLastCellNum();
		for (int j = 0; j < cc; j++)
		{
			System.out.println(ws.getRow(i).getCell(j).getStringCellValue());
			
		}
	}
	
}
}
