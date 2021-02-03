package com.qa.crm.pro.base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import com.qa.crm.pro.pages.HomePage;
import com.qa.crm.pro.pages.LoginPage;

public class BaseTest {
public WebDriver dr;
	public BasePage basepage;
	
	public LoginPage loginpage; 
	public HomePage homepage;
	@BeforeTest
	public void setUp(){
		basepage = new BasePage();
	dr=	basepage.init_Browser("chrome");
	loginpage= new LoginPage(dr);
		
	}
	@AfterTest
	public void tearDown() {
		
		dr.close();
		
	}
}
