package com.stockAccounting.Testcase;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.stockAccounting.master.testngStockAccMaster;
@Test
public class tesngsuppliercreation extends testngStockAccMaster {
	public void stockAcc_supplier( /*String supname,String sadd,String scity,String scountry,String scontperson,
			String Sphnnumber,String semail,String smbnum,String snotes*/ ){
		expval="Add succeeded";
		driver.findElement(By.linkText(pr.getProperty("supplierbutton"))).click();
		driver.findElement(By.xpath(pr.getProperty("Addbutton"))).click();
		driver.findElement(By.id(pr.getProperty("Supplier_Name"))).sendKeys("aman");
		driver.findElement(By.id(pr.getProperty("Address"))).sendKeys("madhapur");
		driver.findElement(By.id(pr.getProperty("City"))).sendKeys("hyderabad");
		driver.findElement(By.id(pr.getProperty("Country"))).sendKeys("india");
		driver.findElement(By.id(pr.getProperty("Contact_Person"))).sendKeys("shiva");
		driver.findElement(By.id(pr.getProperty("Phone_Number"))).sendKeys("235323535");
		driver.findElement(By.id(pr.getProperty("Email"))).sendKeys("abc@gmail.com");
		driver.findElement(By.id(pr.getProperty("Mobile_Number"))).sendKeys("04545454");
		driver.findElement(By.id(pr.getProperty("Notes"))).sendKeys("notes related with bookx");
		driver.findElement(By.id(pr.getProperty("button"))).click();
		driver.findElement(By.xpath("html/body/div[17]/div[2]/div/div[4]/div[2]/button[1]")).click();
		String actval=driver.findElement(By.xpath("html/body/div[17]/div[2]/div/div[3]/div/div")).getText();
		Assert.assertEquals(actval, expval,"Test case failed");
}
}