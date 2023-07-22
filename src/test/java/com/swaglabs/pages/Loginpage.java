package com.swaglabs.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {
WebDriver driver;

@FindBy(id="user-name")
private WebElement username;

@FindBy(id="password")
private WebElement password;

@FindBy(id="login-button")
private WebElement login;

public Loginpage(WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements(driver,this);
}
public void setUserName(String strUserName)
{
username.sendKeys(strUserName);	
}
public void setPassword(String strPassword)
{
	password.sendKeys(strPassword);
}

public void clickLogin()
{
	login.click();
}
}


