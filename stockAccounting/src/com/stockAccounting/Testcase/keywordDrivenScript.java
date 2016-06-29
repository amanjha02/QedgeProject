package com.stockAccounting.Testcase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import com.stockAccounting.master.StockMaster;

public class keywordDrivenScript {
	public static FileInputStream fis;
	public static String excelpath = "D:\\workspace\\stockAccounting\\src\\com\\stockAccounting\\Testdata\\keyword.xlsx";
	public static String xlOut = "D:\\workspace\\stockAccounting\\src\\com\\stockAccounting\\Result\\keyout.xlsx";

	@Test
	public void keywordScript() throws IOException {
		String res = null;
		StockMaster sm = new StockMaster();
		fis = new FileInputStream(excelpath);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet ws1 = wb.getSheet("TestCase");
		XSSFSheet ws2 = wb.getSheet("TestSteps");
		XSSFSheet ws3 = wb.getSheet("Testdata");
		int TcRc = ws1.getLastRowNum();
		int TsRc = ws2.getLastRowNum();
		int Tsdata = ws3.getLastRowNum();

		for (int i = 1; i <= TcRc; i++) {
			String tcexe = ws1.getRow(i).getCell(0).getStringCellValue();
			for (int j = 1; j <= TsRc; j++) {
				String tsid = ws2.getRow(i).getCell(0).getStringCellValue();
				if (tcexe.equalsIgnoreCase(tsid)) {
					String key = ws2.getRow(j).getCell(3).getStringCellValue();
					switch (key) {
					case "sLanch":
						res = sm.stockAcc_launch(sm.url);
						break;

					case "sLogin":
						res = sm.stockAcc_Login("admin", "master");
						break;
					case "sLogout":
						res = sm.Stock_Logout();
						sm.driverclose();
						break;
					case "sSupplier":
						String supname = ws3.getRow(1).getCell(0)
								.getStringCellValue();
						String sadd = ws3.getRow(1).getCell(1)
								.getStringCellValue();
						String scity = ws3.getRow(1).getCell(2)
								.getStringCellValue();
						String scountry = ws3.getRow(1).getCell(3)
								.getStringCellValue();
						String scontperson = ws3.getRow(1).getCell(4)
								.getStringCellValue();
						String Sphnnumber = ws3.getRow(1).getCell(5)
								.getStringCellValue();
						String semail = ws3.getRow(1).getCell(6)
								.getStringCellValue();
						String smbnum = ws3.getRow(1).getCell(7)
								.getStringCellValue();
						String snotes = ws3.getRow(1).getCell(8)
								.getStringCellValue();
						res = sm.stockAcc_supplier(supname, sadd, scity,
								scountry, scontperson, Sphnnumber, semail,
								smbnum, snotes);
						break;
					case "sCat":
						String Categories = ws3.getRow(1).getCell(9)
								.getStringCellValue();
						res = sm.Stockcategory_creation(Categories);
						break;
					case "sUom":
						String UM_ID = ws3.getRow(1).getCell(10)
								.getStringCellValue();
						String Unit_Description = ws3.getRow(1).getCell(11)
								.getStringCellValue();
						res = sm.Stock_Unitcategory(UM_ID, Unit_Description);
						break;

					default:
						System.out.println("Select a proper keyword");
						break;
					}
					ws2.getRow(j).createCell(4).setCellValue(res);

					if (!ws2.getRow(j).getCell(4).getStringCellValue().equalsIgnoreCase("Fail"))
					{
						ws2.getRow(i).createCell(3).setCellValue(res);
					} 
					else
					{
						ws2.getRow(i).createCell(3).setCellValue("Fail");
					}
				}

				else {
					ws1.getRow(i).createCell(3).setCellValue("BLOCKED");
				}
				FileOutputStream fo = new FileOutputStream(xlOut);
				wb.write(fo);
				wb.close();
			}

		}

	}
}