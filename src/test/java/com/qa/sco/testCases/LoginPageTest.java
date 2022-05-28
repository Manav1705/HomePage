package com.qa.sco.testCases;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.sco.base.TestBase;
import com.qa.sco.pages.HomePage;





public class LoginPageTest extends TestBase {

	HomePage homepage;
	
	

	
	@BeforeMethod
	public void setUp() {
		initialization();             //Call method from parent class
	     homepage = new HomePage();                             //To write this for calling  from other class
	 //   nextpage = new nextPage();
		}
	//verify webelement display
	@Test(groups = {"Test1"})
	public void veriftyUsernameInputPresent() {
		Assert.assertEquals(homepage.verifyUserName(),true);
		
	}
	
	@Test(groups = {"Test1"})
	public void verifyPasswordInputPresent() {
	Assert.assertEquals(homepage.verifyPassword(),true);
	
	}
	@Test(groups ={"Test1"})
	public void verifyLoginButtonPresent() {
	
	Assert.assertEquals(homepage.verifySignIn(),true);
	}
	//verify alert message for all combination of username and password
	@Test(groups = {"Test1"})
	public void verifytWithoutUserNameANDPassword() {
	
	Assert.assertEquals(homepage.WithoutUserNameANDPassword(),"Please fill in this field.");
	}
	
	@Test(groups = {"Test1"})
	public void verifyWithoutPasswordWithUsername() {
	
	Assert.assertEquals(homepage.WithoutPasswordWithUsername(prop.getProperty("username")),"Please fill in this field.");
	}
	@Test(groups = {"Test1"})
	public void verifyWithoutUsernameWithPassword() {
	
	Assert.assertEquals(homepage.WithoutUsernameWithPassword(prop.getProperty("password")),"Please fill in this field.");
	}
	@Test(groups = {"Test1"})
	public void verifyUsernamWithoutSpecCharWithPassword() {
	
	Assert.assertEquals(homepage.UsernameWithoutSpecCharWithPassword(prop.getProperty("username"), prop.getProperty("password")),"Please enter an email address.");
	}
	@Test(groups = {"Test1"})
	public void verifyUsernamWithSpecCharWithPassword() {
	
	homepage = homepage.UsernamWithSpecCharWithPassword(prop.getProperty("username"), prop.getProperty("password"));
	}

	
	//Test 2  
	 @Test(groups = "Test2")
	  public void verifytotalListgroup()  {
		  
		 Assert.assertEquals(homepage.ListOfOptions(), 3);
	
	  }
	 
	 @Test(groups = "Test2")
	  public void verifySecondListItem()  {
		 
		 Assert.assertEquals(homepage.Option2(),"List Item 2");
		  
	  }
	 @Test(groups = "Test2")
	  public void verifyBudgeValueOfSecondListItem()  {
		 Assert.assertEquals(homepage.budgevalueOption2(), "6");
	  }
	 //Test 3

	 @Test(groups = "Test3")
	  public void verifyDefaultOption() {
		 Assert.assertEquals(homepage.dropdownDefaultSelect(), "Option 1");
	  }
	 @Test(groups = "Test3")
	  public void verifyAfterSelection() {
		 Assert.assertEquals(homepage.selectOption3(), "Option 3");
		
	  }
	 //Test 4
	 @Test(groups = "Test4")
	  public void verifyFirstEnableButton() {
			 Assert.assertEquals(homepage.enableButton(), true);
		  }
	 @Test(groups = "Test4")
	  public void verifySecondDisableButton() throws InterruptedException {
			 Assert.assertEquals(homepage.disableButton(), false);
		  }
	 //Test5
	 @Test(groups = "Test5")
	  public void Test5button() throws InterruptedException {
			 Assert.assertEquals(homepage.Test5buttonAlertText(),"You clicked a button!");
		  }
	 @Test(groups = "Test5")
	  public void Test5buttonDisable() throws InterruptedException {
			 Assert.assertEquals(homepage.Test5ButtonDisable(),false);
		  }
	 //Test 6
	 @Test(groups = "Test6")
	 public void cellValue() {
		 Assert.assertEquals(homepage.Test6(),"Ventosanzap");
		 
		 
	 }
	 
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}


