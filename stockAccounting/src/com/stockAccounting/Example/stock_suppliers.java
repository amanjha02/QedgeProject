package com.stockAccounting.Example;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.server.browserlaunchers.Sleeper;

public class stock_suppliers {
	public static String url="http://webapp.qedgetech.com";
	public static WebDriver driver;
	
	
public static void main(String[] args) {
	
	stock_suppliers sc=new stock_suppliers();
	
 driver=new FirefoxDriver();
	
	
//	driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
String expval="Add succeeded";
	driver.get(url);
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	driver.findElement(By.id("username")).clear();
	driver.findElement(By.id("username")).sendKeys("admin");
	driver.findElement(By.id("password")).clear();
	driver.findElement(By.id("password")).sendKeys("master");
	driver.findElement(By.id("btnsubmit")).click();
	//sc.stock_category();
	//this part is stock category
	/*WebElement element=driver.findElement(By.xpath(".//*[@id='mi_a_stock_items']/a"));
	Actions ac=new Actions(driver);
	ac.moveToElement(element).build().perform();
	driver.findElement(By.linkText("Stock Categories")).click();
	driver.findElement(By.xpath(".//*[@id='ewContentColumn']/div[3]/div[1]/div[1]/div[1]/div/a")).click();
	driver.findElement(By.id("x_Category_Name")).sendKeys("arithmeticbooks");
	driver.findElement(By.id("btnAction")).click();
	Sleeper.sleepTightInSeconds(9);
	driver.findElement(By.xpath("//*[@class='ajs-modal']/div[1]/div[4]/div[2]/button[1]")).click();
	String val=driver.findElement(By.xpath("html/body/div[17]/div[2]/div/div[3]/div/div")).getText();
	System.out.println(val);
	driver.findElement(By.xpath("//*[@class='ajs-footer']/div[2]/button[1]")).click();*/
	///this part of suplier
	driver.findElement(By.linkText("Suppliers")).click();
	driver.findElement(By.xpath(".//*[@id='ewContentColumn']/div[3]/div[1]/div[1]/div[1]/div/a/span")).click();
	driver.findElement(By.id("x_Supplier_Name")).sendKeys("aman");
	driver.findElement(By.id("x_Address")).sendKeys("madhapur");
	driver.findElement(By.id("x_City")).sendKeys("hyderabad");
	driver.findElement(By.id("x_Country")).sendKeys("india");
	driver.findElement(By.id("x_Contact_Person")).sendKeys("vamsi");
	driver.findElement(By.id("x_Phone_Number")).sendKeys("8965231472");
	driver.findElement(By.id("x__Email")).sendKeys("abc@gmail.com");
	driver.findElement(By.id("x_Mobile_Number")).sendKeys("8965231473");
	driver.findElement(By.id("x_Notes")).sendKeys("delivered 100 piece");
	driver.findElement(By.id("btnAction")).click();
	driver.findElement(By.xpath("html/body/div[17]/div[2]/div/div[4]/div[2]/button[1]")).click();
	String actval=driver.findElement(By.xpath("html/body/div[17]/div[2]/div/div[3]/div/div")).getText();
	System.out.println(actval);
	driver.findElement(By.xpath("html/body/div[17]/div[2]/div/div[4]/div[2]/button")).click();
	if(expval.equalsIgnoreCase(actval)){
		System.out.println("pass");
	}
	else{
		System.out.println("fail");
	}
	
	
}

public void stock_category(){
	WebElement element=driver.findElement(By.xpath(".//*[@id='mi_a_stock_items']/a"));
	Actions ac=new Actions(driver);
	ac.moveToElement(element).build().perform();
	driver.findElement(By.linkText("Unit of Measurement")).click();
	driver.findElement(By.xpath(".//*[@id='ewContentColumn']/div[3]/div[1]/div[1]/div[1]/div/a")).click();
	driver.findElement(By.id("x_UOM_ID")).sendKeys("65435356452");
	driver.findElement(By.id("x_UOM_Description")).sendKeys("record for book");
	driver.findElement(By.id("btnAction")).click();
	driver.findElement(By.xpath("//*[@class='ajs-footer']/div[2]/button[1]")).click();
	String val=driver.findElement(By.xpath("html/body/div[3]/div[2]/div/div[3]/div/div")).getText();
	System.out.println(val);
	Sleeper.sleepTightInSeconds(9);
	driver.findElement(By.xpath("//*[@class='ajs-footer']/div[2]/button[1]")).click();
	System.out.println("pass");
	
	
}
}
