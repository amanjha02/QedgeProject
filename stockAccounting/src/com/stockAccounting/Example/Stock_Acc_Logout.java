package com.stockAccounting.Example;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Stock_Acc_Logout {
	public static Select select;
	public static Actions ac;
	public static FileInputStream fi;
	public static WebDriver driver;
	public static Properties pr;
	public static String url="http://webapp.qedgetech.com";
public static void main(String[] args) {
	driver=new FirefoxDriver();
	driver=new FirefoxDriver();
	pr=new Properties();
	
	
//	driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	driver.get(url);
	driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	
	driver.findElement(By.id("username")).clear();
	driver.findElement(By.id("username")).sendKeys("admin");
	driver.findElement(By.id("password")).clear();
	driver.findElement(By.id("password")).sendKeys("master");
	driver.findElement(By.id("btnsubmit")).click();
	driver.findElement(By.id("logout")).click();
	/*String str=driver.findElement(By.xpath("//*[@class='ajs-primary ajs-buttons']/button[1]")).getText();
     driver.findElement(By.xpath("//*[@class='ajs-primary ajs-buttons']/button[1]")).click();
	System.out.println(str);*/
	driver.findElement(By.cssSelector(".ajs-button.btn.btn-primary")).click();
	
}
}
