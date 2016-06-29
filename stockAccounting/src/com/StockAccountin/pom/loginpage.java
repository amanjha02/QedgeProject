package com.StockAccountin.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class loginpage {
	
	public String URl="http://webapp.qedgetech.com/login.php";
	
	public String uid="admin",pawd="master";
	@FindBy(id="username")
	WebElement username;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(id="btnsubmit")
	WebElement login;
	
	@FindBy(id="btnreset")
	WebElement reset;
	
	public void s_Login(String uid ,String pawd){
		reset.click();
		username.clear();
		username.sendKeys(uid);
		password.clear();
		password.sendKeys(pawd);
		login.click();
		
	}

}
