package com.stockAccounting.Testcase;

import java.io.IOException;

import com.stockAccounting.master.StockMaster;

public class StockAccLogintest {
	public static void main(String[] args) throws IOException {
		StockMaster sm=new StockMaster();
		String res=sm.stockAcc_launch(sm.url);
		System.out.println(res);
		
		
		
	}

}
