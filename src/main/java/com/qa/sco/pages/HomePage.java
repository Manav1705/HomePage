package com.qa.sco.pages;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.sco.base.TestBase;
import com.qa.sco.utility.TestUtil;



public class HomePage extends TestBase {

	
	JavascriptExecutor jse = (JavascriptExecutor)driver;
	String spec = "@";
	String ch = "12";
	//Page Factory - Object Repositary:
	
	@FindBy(id="inputEmail")
	WebElement username;
	
	@FindBy(id="inputPassword")
	WebElement password;

	@FindBy(xpath="//button[contains(text(), 'Sign in')] ")
	WebElement login;
	
	@FindBy(xpath = "//li[contains(@class,'list-group-item')]")	
	List<WebElement> itemList;

	@FindBy(xpath = "//li[contains(@class,'list-group-item')][2]/span")
	WebElement budgeValueOfOption2;
	
	@FindBy(id ="dropdownMenuButton")
	WebElement dropdownMenu;
	
	@FindBy(xpath ="//a[contains(text(),'Option 3')]")
	WebElement option3;
	
	@FindBy(xpath ="//*[@id='test-4-div']/button[1]")
	WebElement enableButton;
	
	@FindBy(xpath ="//*[@id='test-4-div']/button[2]")
	WebElement disableButton;
	
	@FindBy(xpath ="//*[@id='test5-button']")
	WebElement Button;
	
	@FindBy(xpath ="//*[@id='test5-alert']")
	WebElement afterClickOnButtonAlert;
	
	@FindBy(xpath ="//*[@id='test-6-div']/div/table/tbody//tr")
	List<WebElement> rows;
	
	@FindBy(xpath ="//*[@id='test-6-div']/div/table//tr[2]/td")
	List<WebElement> cols;
	
	
	
	
	
	
	//Initialization the Page Objects:
	public HomePage() {
		PageFactory.initElements(driver,this);
		
	}

	//Actions for webelement display
	public boolean verifyUserName() {
		return username.isDisplayed();
		
		}
	public boolean verifyPassword() {
		return password.isDisplayed();
		
		}
	public boolean verifySignIn() {
		return login.isDisplayed();
		
		}
	
	//Intialize class for JS alert messge
	public String javascriptAlertUsername() {
		return (String) jse.executeScript("return arguments[0].validationMessage",username);
	}
	public String javascriptAlertPassword() {
		return (String) jse.executeScript("return arguments[0].validationMessage",password);
	}
	
	// Different Combination of Username and Password
	public String WithoutUserNameANDPassword() {
		login.click();
		return javascriptAlertUsername();
		}
	public String WithoutPasswordWithUsername(String un) {
		
		username.sendKeys(un+spec+ch);
		login.click();
		return javascriptAlertPassword();
	}
	public String WithoutUsernameWithPassword(String pw) {
		password.sendKeys(pw);
		login.click();
		return javascriptAlertUsername();
		
	}
	public String UsernameWithoutSpecCharWithPassword(String un,String pw) {
		username.sendKeys(un);
		password.sendKeys(pw);
		login.click();
		return javascriptAlertUsername();
	}
	public HomePage UsernamWithSpecCharWithPassword(String un,String pw) {
		username.sendKeys(un+spec+ch);
		password.sendKeys(pw);
		login.click();
		
		return new HomePage();
	}
	
	//Test 2 
	public int ListOfOptions() {
		
			return itemList.size();
		
		}
	public String Option2() {
		
		String option2 = itemList.get(1).getText();
		option2 = option2.replaceFirst(budgeValueOfOption2.getText(),"").trim();
		System.out.println(option2);
		return option2;
		
		}
	public String budgevalueOption2() {
		
		return budgeValueOfOption2.getText();
		
	}
	//Test 3
	public String dropdownDefaultSelect() {
		
		return dropdownMenu.getText().trim();
		
	}

	public String selectOption3() {
		
		dropdownMenu.click();
		option3.click();
		return dropdownMenu.getText().trim();
		
	}
	
	//Test 4
	public boolean enableButton() {
		return enableButton.isEnabled();
		}
	public boolean disableButton() {
		return disableButton.isEnabled();
		}
	
	//Test 5
	public void Test5() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(Button));
		Button.click();
	}
	public String Test5buttonAlertText() {
		Test5();
		return afterClickOnButtonAlert.getText().trim();
		
		}
	public boolean Test5ButtonDisable() {
		Test5();
		return Button.isEnabled();
	}
	
	//Test 6
	
	public String allTableValue(int a,int b) {
		int rowCount = driver.findElements(By.xpath("//*[@id='test-6-div']/div/table/tbody//tr")).size();  //Get number of rows
		System.out.println("Number of rows : " +rowCount); 
		 int columnCount = driver.findElements(By.xpath("//*[@id='test-6-div']/div/table//tr[2]/td")).size();  //Get number of columns
		 System.out.println("Number of columns : " +columnCount);
			

		String[][] reportMatrix = new String[rowCount][columnCount];    
			                              
		for(int i=0;i<=rowCount-1;i++)  
			{
			    for(int j=0;j<=columnCount-1;j++)    
			    {
			        String text = driver.findElement(By.xpath("//*[@id='test-6-div']/div/table//tr["+(i+1)+"]/td["+(j+1)+"]")).getText();  

			      System.out.print(text+" ");

			      reportMatrix[i][j] = text;  
			       
			    }
			 System.out.println();
			}
		return reportMatrix [a][b];
		}

		
	
	public String Test6() {
		
		return allTableValue(2,2);
		
	}

	
	
}