package com.stockAccounting.Testcase;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.stockAccounting.master.StockMaster;

public class LoginTest {
	public static void main(String[] args) throws IOException {
		StockMaster sm=new StockMaster();
		String res=sm.stockAcc_launch(sm.url);
		System.out.println(res);
		
		res=sm.stockAcc_Login("admin", "master");
		System.out.println(res);
		
		

		//res=sm.Stock_Logout();
		//System.out.println(res);
		////sm.driverclose();
		
		 
		//String suppliersdetail=sm.stockAcc_supplier("aman1", "madhapur", "hyd", "india", "raghav", 
		//"12525424", "abc@gmail.com", "556565565", "200 quantity");
		//System.out.println(suppliersdetail);
		//
		
		
	//category creation
		//String Category= sm.Stockcategory_creation("Books5657");
		//System.out.println(Category);
		res=sm.Stock_Creation("12000", "15000","booksselling");
		System.out.println(res);
		 //unit measurement creation
		//String UnitMeasurement=sm.Stock_Unitcategory("UOM56546", "Book record") ;
		//System.out.println(UnitMeasurement);
		//res=sm.Stock_Logout();
		//System.out.println(res);
		
	}
	

}
