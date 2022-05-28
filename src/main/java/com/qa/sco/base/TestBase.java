package com.qa.sco.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.qa.sco.utility.TestUtil;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	
	
	public TestBase(){
		
	 try {
		prop = new Properties();	
		FileInputStream ip = new FileInputStream("C:/Selenium_Workspace/frreecrm/src/main/java/com/qa/sco/config/config.properties");
		prop.load(ip);	
	 }catch(FileNotFoundException e) {
		 e.printStackTrace();
	 }catch(IOException e){
		 e.printStackTrace();
		 
	 }
	 	
	}
	
	public static void initialization() {
	  String browserName = prop.getProperty("browser");
	  if(browserName.equals("Firefox")) {
		  System.setProperty("webdriver.gecko.driver", "C:\\SeleniumJars\\geckodriver.exe");
			driver = new FirefoxDriver();  
	  }else if(browserName.equals("Chrome")) {
		  System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver.exe");
			driver = new ChromeDriver();
	  }
	  driver.manage().window().maximize();
	  driver.manage().deleteAllCookies();
	  driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
	  driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICITY_WAIT, TimeUnit.SECONDS);
	  driver.get(prop.getProperty("url"));
	  
	
		
		
	}
	
	
	
	
	
}
