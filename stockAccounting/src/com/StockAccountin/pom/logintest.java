package com.StockAccountin.pom;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.server.browserlaunchers.Sleeper;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class logintest {
	@Test
	
	public void login()
	{
		WebDriver driver =new FirefoxDriver();
		 loginpage lp=PageFactory.initElements(driver, loginpage.class);
		 stockcategorypage sp=PageFactory.initElements(driver, stockcategorypage.class);
		 driver.get(lp.URl);
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(5000,TimeUnit.SECONDS);
		 lp.s_Login(lp.uid, lp.pawd);
		sp.stockitemlink();
		sp.Addbutton();
		sp.stockcategory();
		sp.SupplierNumber();
		Sleeper.sleepTightInSeconds(2);
		sp.stockname();
		sp.uom();
		sp.purchasingprice();
		sp.sellingprice();
		sp.notes();
		sp.clickbutton();
		 Sleeper.sleepTightInSeconds(5);
		 driver.close();	 
	}

}
