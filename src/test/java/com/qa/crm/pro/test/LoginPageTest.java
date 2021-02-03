package com.qa.crm.pro.test;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.*;

import com.qa.crm.pro.base.BaseTest;

public class LoginPageTest extends BaseTest{
	
	
	
	@Test(priority=1)
	public void doLoginTest() {
		
		loginpage.doLogIn("batchautomation", "Test@12345");
		
	}
@Test(priority=2)
	public void dologinVerify() {
		
		AssertJUnit.assertEquals("CRMPR", dr.getTitle());
	}
	
}
