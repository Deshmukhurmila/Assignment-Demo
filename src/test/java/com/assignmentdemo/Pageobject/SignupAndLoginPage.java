package com.assignmentdemo.Pageobject;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.datatable.DataTable;

public class SignupAndLoginPage {
	
	
	
	
private static final String Hashmap = null;

//private static final Logger logger = LogManager.getLogger(SignupAndLoginPage.class);
	
	private WebDriver driver;
	
	private WebDriverWait wait;
	private static final DataTable DataTable = null;
	
	
	
    //Paratmerize the constructor
    public SignupAndLoginPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 15);
    }
    
    // Page Locators
    private By loginSecHeader = By.xpath("//h2[text()='Login to your account']");
//    private By loginEmailIdField = By.xpath("//input[@placeholder='Email Address' and @data-qa='login-email']");
//    private By loginPasswordField = By.xpath("//input[@placeholder='Password' and @data-qa='login-password']");
    private By loginButton = By.xpath("//a[text()=' Signup / Login']']");
    private By UserNameField =By.xpath("//input[@name='email']");
    private By PasswordField = By.xpath("//input[@name='password']");
    
    
    
 // Page Methods
    public void validatesignUpLoginPageTitle(String loginPageTitle)
    {
		wait.until(ExpectedConditions.titleContains("Automation Exercise - Signup / Login"));
		Assert.assertEquals(loginPageTitle, driver.getTitle());
    }
    
    public void validateLoginKeywordInUrl(String loginPageUrlKeyword)
    {
     	wait.until(ExpectedConditions.urlContains(loginPageUrlKeyword));
		Assert.assertEquals(true, driver.getCurrentUrl().contains(loginPageUrlKeyword));
    }
    
    public void validateLoginSectionHeader(String loginPageSecHeader)
    {
    	WebElement loginSecHeaderEle = driver.findElement(loginSecHeader);
		Assert.assertEquals(loginPageSecHeader, loginSecHeaderEle.getText());
    }
    
    public void sendTextToLoginField(String userRegEmailIDtxt)
        {
        	 WebElement loginEmailIdFieldEle = driver.findElement(UserNameField);
		   loginEmailIdFieldEle.sendKeys(userRegEmailIDtxt);
        }
         public void sendTextToPasswordField(String userRegPasswordtxt)
       {
		WebElement loginPasswordFieldEle = driver.findElement(PasswordField);
		loginPasswordFieldEle.sendKeys(userRegPasswordtxt);
       }
   
         public void clickOnLoginButton()
    {
		WebElement loginButtonEle = driver.findElement(loginButton);
		loginButtonEle.click();
         }
         
         public void Checkitsvalidornot()
         {
        	 
        	
//			List<List<String>> Data = DataTable.asList(String.class);
        	List<Map<String,String>> listdata = DataTable.asMaps(String.class,String.class);
        	
        	for(Map<String,String>mapdata:listdata)
        	{
        		driver.findElement(By.xpath("//input[@name='email']")).clear();
        	driver.findElement(By.xpath("//input[@name='email']")).sendKeys(mapdata.get("username1"));
        	driver.findElement(By.xpath("//input[@name='email']")).clear();
			driver.findElement(By.xpath("//input[@name='email']")).sendKeys(mapdata.get("password1"));
        	}
//			driver.findElement(By.xpath("//input[@name='email']")).sendKeys(listdata.get(0).get(0));
//			driver.findElement(By.xpath("//input[@name='email']")).sendKeys(listdata.get(0).get(1));
			
			
//       	 WebElement loginEmailIdFieldEle = driver.findElement(Data.get(0));
//  		   loginEmailIdFieldEle.sendKeys(userRegEmailIDtxt);
// 		 WebElement loginPasswordFieldEle = driver.findElement(PasswordField);
//		  loginPasswordFieldEle.sendKeys(userRegPasswordtxt);
//  		   
         }
         
    
     
     
     
        
        
        
//       
//    	       
//
//    	 
//
//    	        }

    	 

    	}
       


