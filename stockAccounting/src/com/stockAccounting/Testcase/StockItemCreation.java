package com.stockAccounting.Testcase;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.stockAccounting.master.StockMaster;
import com.thoughtworks.selenium.webdriven.JavascriptLibrary;

public class StockItemCreation {
	public WebDriver driver;	

public static void main(String[] args) throws IOException, InterruptedException {
	StockMaster sm=new StockMaster();
	StockItemCreation SItem=new StockItemCreation();
	sm.stockAcc_launch(sm.url);
	sm.stockAcc_Login("admin","master");
	Thread.sleep(2000);
	SItem.Stock_Item_creation();
	
}

public void  Stock_Item_creation(){
	driver.findElement(By.linkText("Stock Items")).click();
	/*WebElement element=driver.findElement(By.xpath(".//*[@id='mi_a_stock_items']/a"));
	Actions action=new Actions(driver);
	action.moveToElement(element).build().perform();
	action.click();*/

	
	//JavascriptExecutor js= (JavascriptExecutor)driver;
	//js.executeScript("argument[0].click();", element);
	//
}
}
