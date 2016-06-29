package com.stockAccounting.master;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class screenshot {
	public static WebDriver driver;
	String scrpath="D:\\workspace\\stockAccounting\\src\\com\\stockAccounting\\screenshot";
	public static void main(String[] args) throws IOException {
		driver=new FirefoxDriver();
		driver.get("https://www.google.com");
		screenshot screen=new screenshot();
		screen.takescreenshot("google.png");
		
	}
	public void takescreenshot(String name) throws IOException{
		
		File srcfile= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(srcfile, new File(scrpath+"\\"+name));
	
	}
}


