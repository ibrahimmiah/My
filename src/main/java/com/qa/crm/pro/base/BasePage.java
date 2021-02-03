package com.qa.crm.pro.base;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {

private WebDriver dr;	
	
public static ThreadLocal<WebDriver> tldr = new ThreadLocal<WebDriver>();
public WebDriver init_Browser(String browsername) {
	
	if(browsername.equalsIgnoreCase("chrome")) {
		
		WebDriverManager.chromedriver().setup();
		//dr= new ChromeDriver();
		tldr.set(new ChromeDriver());
	}else if(browsername.equalsIgnoreCase("firefox")) {
		
		WebDriverManager.firefoxdriver().setup();
		//dr= new FirefoxDriver();
		tldr.set(new FirefoxDriver());
		
	}else if(browsername.equalsIgnoreCase("safari")) {
		//WebDriverManager.getInstance(SafariDriver.class);
		//dr = new SafariDriver();
		tldr.set(new SafariDriver());
	}else {
		System.out.println("please Enter Proper browser "+browsername);
	}
	getDr().manage().window().maximize();
	getDr().manage().deleteAllCookies();
	getDr().get("https://classic.crmpro.com/");
	return getDr();
	
}

public static synchronized WebDriver getDr() {
	return tldr.get();
	
}
public String getScreenshot() {
	File src = ((TakesScreenshot) getDr()).getScreenshotAs(OutputType.FILE);
	String path = System.getProperty("user.dir") + "/screenshots/" + System.currentTimeMillis() + ".png";
	File destination = new File(path);
	try {
		FileUtils.copyFile(src, destination);
	} catch (IOException e) {
		e.printStackTrace();
		
	}
	return path;
}	
	
}
