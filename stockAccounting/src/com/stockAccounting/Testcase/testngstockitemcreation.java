package com.stockAccounting.Testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.server.browserlaunchers.Sleeper;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.stockAccounting.master.testngStockAccMaster;
@Test
public class testngstockitemcreation extends testngStockAccMaster {
	public  void  Stock_Creation(/*String purchasingprice ,String sellingprice,String sellingnotes*/ ){
	expval="Add succeeded";
	driver.findElement(By.linkText(pr.getProperty("Stock_item_link"))).click();
	driver.findElement(By.xpath(pr.getProperty("+_button"))).click();
	 WebElement Stock_creation=driver.findElement(By.id(pr.getProperty("category_dropdown")));
	Select select=new Select(Stock_creation);
	Sleeper.sleepTightInSeconds(5);
	select.selectByIndex(1);
	
	WebElement elmentSuppliernumber=driver.findElement(By.id(pr.getProperty("suppliernumber_dropdowm")));
	Select select_Supplier_number=new Select(elmentSuppliernumber);
	select_Supplier_number.selectByIndex(1);
	
	
	driver.findElement(By.id(pr.getProperty("stockname"))).sendKeys("bookstock");
	
	WebElement UOM=driver.findElement(By.id(pr.getProperty("UOM_Dropdowm")));
	Select UOMeasurement=new Select(UOM);
	UOMeasurement.selectByVisibleText("Dozen");
	
	driver.findElement(By.id(pr.getProperty("Puchasing_Price"))).sendKeys("10000");
	driver.findElement(By.id(pr.getProperty("selling_Price"))).sendKeys("200000");
	driver.findElement(By.id(pr.getProperty("selling_Notes"))).sendKeys("notess");
	driver.findElement(By.id(pr.getProperty("Stockcreation_button"))).click();
	// actval= driver.findElement(By.xpath("html/body/div[19]/div[2]/div/div[3]/div")).getText();
	 driver.findElement(By.xpath("//*[@class='ajs-primary ajs-buttons']/button[1]")).click();
	 actval=driver.findElement(By.xpath("html/body/div[17]/div[2]/div/div[3]/div/div")).getText();
	 driver.findElement(By.xpath("html/body/div[17]/div[2]/div/div[4]/div[2]/button")).click();
	 Assert.assertEquals(actval, expval,"Test case failed");
}
}
