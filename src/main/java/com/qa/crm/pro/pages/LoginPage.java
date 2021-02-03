package com.qa.crm.pro.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

	private WebDriver dr;
	
	By userName = By.xpath("//input[@name='username']");
	
	
	By passWord=By.xpath("//input[@name='password']");
	By loginButton= By.xpath("//input[@class='btn btn-small']");
	public LoginPage(WebDriver dr) {
		
	this.dr = dr;
		
	}
	
	public HomePage doLogIn(String username1,String password1) {
		
		dr.findElement(userName).sendKeys(username1);
		dr.findElement(passWord).sendKeys(password1);
		dr.findElement(loginButton).click();
		
		return new HomePage(dr);
	}
	

}
