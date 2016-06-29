package com.stockAccounting.master;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.server.browserlaunchers.Sleeper;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class StockMaster{
	public static Select select;
	public static Actions ac;
	public static FileInputStream fi;
	public static WebDriver driver;
	public static Properties pr;
	public static String url="http://webapp.qedgetech.com";
	public static String expval,actval;
	public static String prop="D:\\workspace\\stockAccounting\\src\\com\\stockAccounting\\Proerties\\stockAcc.properties";
	/*
	public String stockAcc_launch(String url) throws FileNotFoundException
	{
		
		
		driver=new FirefoxDriver();
		pr=new Properties();
		fi=new FileInputStream(prop);
		
//		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		expval="login";
		actval=driver.findElement(By.id("btnsubmit")).getText();
		if(actval.equalsIgnoreCase(expval)){
			return "pass";
		}
		else{
			return "false";
		}
	}*/
	
	/*public String stockAcc_Login(String usename,String Pwd)
	{
		driver.findElement(By.id("username")).clear();
		driver.findElement(By.id("username")).sendKeys(usename);
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys(Pwd);
		driver.findElement(By.id("btnsubmit")).click();
		expval="Administrator";
		actval=driver.findElement(By.xpath(".//*[@id='msUserName']/font/strong")).getText();
		if(expval.equalsIgnoreCase(actval)){
			return "Pass";
		}
		else{
			return "Fail";
		}
	}
	public String Stock_Logout(){
		driver.findElement(By.id("logout")).click();
		driver.findElement(By.xpath("html/body/div[17]/div[2]/div/div[4]/div[2]/button[1]")).click();
		//driver.switchTo().alert().accept();
		
		expval="login";
		actval=driver.findElement(By.id("btnsubmit")).getText();
		if(expval.equalsIgnoreCase(actval)){
			return "Pass";
		}
		else{
			return "Fail";
		}
	}
	public void driverclose(){
		driver.close();
	}*/

	
   public String stockAcc_launch(String url) throws IOException{
		fi=new FileInputStream(prop);
		 pr=new Properties();
		 pr.load(fi);
		 driver=new FirefoxDriver();
		 driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		 driver.get(url);
		 driver.manage().window().maximize();	

	
	expval="Login";
	actval=driver.findElement(By.id(pr.getProperty("login"))).getText();
	if(actval.equalsIgnoreCase(expval)){
		return "pass";
	}
	else{
		return "false";
	}
   }


public String stockAcc_Login(String usename,String Pwd)
{
	driver.findElement(By.id(pr.getProperty("username"))).clear();
	driver.findElement(By.id(pr.getProperty("username"))).sendKeys(usename);
	driver.findElement(By.id(pr.getProperty("password"))).clear();
	driver.findElement(By.id(pr.getProperty("password"))).sendKeys(Pwd);
	driver.findElement(By.id(pr.getProperty("login"))).click();
	expval="Administrator";
	actval=driver.findElement(By.xpath(".//*[@id='msUserName']/font/strong")).getText();
	if(expval.equalsIgnoreCase(actval)){
		return "Pass";
	}
	else{
		return "Fail";
	}
}
public String Stock_Logout(){

	driver.findElement(By.id(pr.getProperty("logout"))).click();
	List <WebElement> logoutalert=driver.findElements(By.tagName("button"));
	int number=logoutalert.size();
	System.out.println(number);
	for( WebElement okbutton:logoutalert){
		String buttonvalue=okbutton.getText();
		if(buttonvalue.equalsIgnoreCase("OK!")){
			okbutton.click();
		}
	}
	

	//driver.findElement(By.xpath(pr.getProperty("confirmationbutton"))).click();
	//driver.switchTo().alert().accept();
	
	expval="login";
	actval=driver.findElement(By.id(pr.getProperty("login"))).getText();
	if(expval.equalsIgnoreCase(actval)){
		return "Pass";
	}
	else{
		return "Fail";
	}
}
public void driverclose(){
	driver.close();
}

public String stockAcc_supplier( String supname,String sadd,String scity,String scountry,String scontperson,
		String Sphnnumber,String semail,String smbnum,String snotes ){
	expval="Add succeeded";
	driver.findElement(By.linkText(pr.getProperty("supplierbutton"))).click();
	driver.findElement(By.xpath(pr.getProperty("Addbutton"))).click();
	driver.findElement(By.id(pr.getProperty("Supplier_Name"))).sendKeys(supname);
	driver.findElement(By.id(pr.getProperty("Address"))).sendKeys(sadd);
	driver.findElement(By.id(pr.getProperty("City"))).sendKeys(scity);
	driver.findElement(By.id(pr.getProperty("Country"))).sendKeys(scountry);
	driver.findElement(By.id(pr.getProperty("Contact_Person"))).sendKeys(scontperson);
	driver.findElement(By.id(pr.getProperty("Phone_Number"))).sendKeys(Sphnnumber);
	driver.findElement(By.id(pr.getProperty("Email"))).sendKeys(semail);
	driver.findElement(By.id(pr.getProperty("Mobile_Number"))).sendKeys(smbnum);
	driver.findElement(By.id(pr.getProperty("Notes"))).sendKeys(snotes);
	driver.findElement(By.id(pr.getProperty("button"))).click();
	driver.findElement(By.xpath("html/body/div[17]/div[2]/div/div[4]/div[2]/button[1]")).click();
	String actval=driver.findElement(By.xpath("html/body/div[17]/div[2]/div/div[3]/div/div")).getText();
	System.out.println(actval);
	driver.findElement(By.xpath("html/body/div[17]/div[2]/div/div[4]/div[2]/button")).click();
	if(expval.equalsIgnoreCase(actval)){
		return "pass";
	}
	else{
		return "Fail";
	}
	
}
public String Stockcategory_creation(String Categories){
	expval="Add succeeded";
    WebElement element=driver.findElement(By.linkText(pr.getProperty("Stock_item_link")));
    ac=new Actions(driver);
	ac.moveToElement(element).build().perform();
	driver.findElement(By.linkText(pr.getProperty("categories_link"))).click();
	driver.findElement(By.xpath(pr.getProperty("Add_button"))).click();
	driver.findElement(By.id(pr.getProperty("Category_Name"))).sendKeys(Categories);
	driver.findElement(By.id(pr.getProperty("Add"))).click();
	Sleeper.sleepTightInSeconds(9);
	driver.findElement(By.xpath("//*[@class='ajs-modal']/div[1]/div[4]/div[2]/button[1]")).click();
	String actval=driver.findElement(By.xpath("html/body/div[17]/div[2]/div/div[3]/div/div")).getText();
	driver.findElement(By.xpath("//*[@class='ajs-footer']/div[2]/button[1]")).click();
	if(actval.equalsIgnoreCase(expval))
	{
		return "Pass";
	}
	else
	{
		return "Fail";
	}
}
public String Stock_Unitcategory(String UM_ID ,String Unit_Description){
	expval="Add succeeded";
	WebElement element=driver.findElement(By.linkText(pr.getProperty("Stock_item_link")));
	Actions ac=new Actions(driver);
	ac.moveToElement(element).build().perform();
	driver.findElement(By.linkText(pr.getProperty("Unit_of_measurement"))).click();
	driver.findElement(By.xpath(pr.getProperty("UOM_Add_button"))).click();
	driver.findElement(By.id(pr.getProperty("UOM_id"))).sendKeys(UM_ID);
	driver.findElement(By.id(pr.getProperty("UOM_description"))).sendKeys(Unit_Description);
	driver.findElement(By.id(pr.getProperty("uoi_Add"))).click();
	driver.findElement(By.xpath("//*[@class='ajs-footer']/div[2]/button[1]")).click();
	actval=driver.findElement(By.xpath("html/body/div[3]/div[2]/div/div[3]/div/div")).getText();
	Sleeper.sleepTightInSeconds(9);
	driver.findElement(By.xpath("//*[@class='ajs-footer']/div[2]/button[1]")).click();
	if(actval.equalsIgnoreCase(expval))
	{
		return "Pass";
	}
	else
	{
		return "Fail";
	}
	
}

public  String  Stock_Creation(String purchasingprice ,String sellingprice,String sellingnotes ){
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
	
	driver.findElement(By.id(pr.getProperty("Puchasing_Price"))).sendKeys(purchasingprice);
	driver.findElement(By.id(pr.getProperty("selling_Price"))).sendKeys(sellingprice);
	driver.findElement(By.id(pr.getProperty("selling_Notes"))).sendKeys(sellingnotes);
	driver.findElement(By.id(pr.getProperty("Stockcreation_button"))).click();
	// actval= driver.findElement(By.xpath("html/body/div[19]/div[2]/div/div[3]/div")).getText();
	 driver.findElement(By.xpath("//*[@class='ajs-primary ajs-buttons']/button[1]")).click();
	 actval=driver.findElement(By.xpath("html/body/div[17]/div[2]/div/div[3]/div/div")).getText();
	 driver.findElement(By.xpath("html/body/div[17]/div[2]/div/div[4]/div[2]/button")).click();
	 if(actval.equalsIgnoreCase(expval))
		{
			return "Pass";
		}
		else
		{
			return "Fail";
		}
		
	
	
	/*List<WebElement> listofcategory=element.findElements(By.tagName("option"));
	int count=listofcategory.size();
	System.out.println(count)*/
	/*for(WebElement category:listofcategory){
	String category_value=category.getText();
	if(category_value.equalsIgnoreCase("Books5657"));
		select.selectByVisibleText(category_value);
		break;
	}*/
	
	
	
}

}
