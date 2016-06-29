package com.StockAccountin.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.server.browserlaunchers.Sleeper;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class stockcategorypage {
	
	@FindBy(linkText="Stock Items")
	WebElement st_iteam_link;
	
	@FindBy(xpath=".//*[@id='ewContentColumn']/div[3]/div[1]/div[1]/div[1]/div/a/span")
	WebElement Addbutton;
	
	@FindBy(id="x_Category")
	WebElement category;
	
	@FindBy(id="x_Supplier_Number")
	WebElement Spplier_number;
	
	@FindBy(id="x_Stock_Name")
	WebElement Stockname;
	
	@FindBy(id="x_Unit_Of_Measurement")
	WebElement uom;
	
	@FindBy(id="x_Purchasing_Price")
	WebElement purchasingprice;
	
	@FindBy(id="x_Selling_Price")
	WebElement sellingprice;
	
	@FindBy(id="x_Notes")
	WebElement notes;
	
	@FindBy(id="btnAction")
	WebElement add;
	
	public void stockitemlink(){
		st_iteam_link.click();
	}
	public void Addbutton(){
		Addbutton.click();
	}
	public void stockcategory(){
		 WebElement Stock_creation=category;
			Select select=new Select(Stock_creation);
			Sleeper.sleepTightInSeconds(5);
			select.selectByIndex(1);		
	}
	public void SupplierNumber(){
		WebElement elmentSuppliernumber=Spplier_number;
		Select select_Supplier_number=new Select(elmentSuppliernumber);
		select_Supplier_number.selectByIndex(1);
	}
	public void stockname()
	{
		Stockname.sendKeys("books");
	}
	public void uom()
	{
		uom.sendKeys("dozen");
	}
	public void purchasingprice()
	{
		purchasingprice.sendKeys("12321");
	}
	public void sellingprice()
	{
		sellingprice.sendKeys("10000");
	}
	public void notes()
	{
		notes.sendKeys("this notes for books");
	}
	public void clickbutton()
	{
		add.click();
	}
	
	
}