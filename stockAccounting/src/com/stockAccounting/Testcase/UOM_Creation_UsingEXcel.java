package com.stockAccounting.Testcase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STSourceType;

import com.stockAccounting.master.StockMaster;

public class UOM_Creation_UsingEXcel {
public static void main(String[] args) throws IOException {
	StockMaster sm=new StockMaster();
	String xlpath="D:\\workspace\\stockAccounting\\src\\com\\stockAccounting\\Testdata\\UOMCreationTestdata.xlsx";
	String xlres="D:\\workspace\\stockAccounting\\src\\com\\stockAccounting\\Result\\UOMCreationTestresult1.xlsx";
	
	sm.stockAcc_launch(sm.url);
	sm.stockAcc_Login("admin","master");
	FileInputStream fis=new FileInputStream(xlpath);
	XSSFWorkbook wb=new XSSFWorkbook(fis);
	XSSFSheet ws=wb.getSheet("UomID_Description");
	XSSFRow r=ws.getRow(2);
	XSSFCell c=r.getCell(1);
	//System.out.println(c.getStringCellValue());
	int rownum=ws.getLastRowNum();
	System.out.println(rownum);
	for (int i = 1; i <=rownum; i++) {
		XSSFRow R=ws.getRow(i);
		XSSFCell C=R.getCell(0);
		XSSFCell C1=R.getCell(1);
		XSSFCell C2=R.getCell(2);
		String UID=C.getStringCellValue();
		String UDEC=C1.getStringCellValue();
		String res=sm.Stock_Unitcategory(UID, UDEC);
		C2.setCellValue("Pass");
		//System.out.println(UID+"  "+UDEC);	
		
	}
	
	FileOutputStream fo=new FileOutputStream(xlres);
	wb.write(fo);
	wb.close();
	sm.Stock_Logout();
	sm.driverclose();
	
}
}
