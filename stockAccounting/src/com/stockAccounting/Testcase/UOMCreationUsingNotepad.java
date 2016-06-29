package com.stockAccounting.Testcase;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import com.google.common.io.FileWriteMode;
import com.stockAccounting.master.StockMaster;
public class UOMCreationUsingNotepad {
		public static void main(String[] args) throws IOException
		{
			StockMaster sm=new StockMaster();
			String x="";
			String path="D:\\workspace\\stockAccounting\\src\\com\\stockAccounting\\Testdata\\UOM_TestData.txt";
			String Rpath="D:\\workspace\\stockAccounting\\src\\com\\stockAccounting\\Result\\UOMResult.txt";
			FileReader fr=new FileReader(path);
			BufferedReader br=new BufferedReader(fr);
			br.readLine();
			FileWriter fw=new FileWriter(Rpath);
			BufferedWriter bw=new BufferedWriter(fw);
			bw.write("Uid&Desc&Result");
			bw.newLine();
			sm.stockAcc_launch(sm.url);
			sm.stockAcc_Login("admin", "master");
			
			while ((x=br.readLine())!=null)
			{
				System.out.println(x);
				String[] split=x.split("&");
				String U=split[0];
				String D=split[1];
				System.out.println(U+"--"+D);
				String res=sm.Stock_Unitcategory(U, D);
				bw.write(x+"&"+res);
				bw.newLine();
			}
			bw.close();
			br.close();
			sm.Stock_Logout();
			sm.driverclose();
		}

	}


