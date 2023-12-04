package com.assignmentdemo.Pageobject;
import java.util.List;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LandingPage {
	
	
	
	private WebDriver driver;
	private WebDriverWait wait;
	
    //Paratmerize the constructor
    public LandingPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 15);
    }
    
    // Page Locators
    //private By landingPageLogo = By.xpath("//img[@alt='Website for automation practice']");
    private By signupLoginButton = By.xpath("//a[text()=' Signup / Login']");
    private By logoutButton = By.xpath("//a[text()=' Logout']");
    private By loggedInUserNameTxt = By.xpath("//a[text()= ' Logged in as ']/b");
    private By subsriptionlable = By.xpath("//h2[text()='Subscription']");
    private By Enteremailidfield = By.xpath("//input[@id='susbscribe_email']");
    private By Arrowbuttonclick = By.xpath("//i[@class='fa fa-arrow-circle-o-right']");
    private By ValidatenavbarList = By.xpath("//ul[@class='nav navbar-nav']");
    private By Headersecactuallist = By.xpath("//ul[@class='nav navbar-nav']/li[a]");
    private By Loginbtn = By.xpath("//button[@class='btn btn-default']");
    private By Successalert =By.xpath("//div[text()='You have been successfully subscribed!']");
    // Page Methods

    public void Validatingheaderbtns()
    {
    	WebElement ValidatingheaderbtnsEle = driver.findElement(ValidatenavbarList);
	    Assert.assertEquals(true, ValidatingheaderbtnsEle.isDisplayed());
	    
   }
    
    public void ValidateeleHeaderList(List<String> Validatingheaderbtns)
    {
    	
    	List<String>  HeadersectionListEle = Validatingheaderbtns;
   	List<WebElement> ActBrandcatagoryListEle=driver.findElements(Headersecactuallist);
		  for(int i = 0 ; i < Validatingheaderbtns.size() ;i++)
	  {
		  Assert.assertEquals(true, ActBrandcatagoryListEle.get(i).getText().trim().contains(HeadersectionListEle.get(i).trim()));
		  }
   	   
    }
 
  
    
 
    public void validateSUBSCRIPTIONlablefooter()
    {
		WebElement subsriptionlableele = driver.findElement(subsriptionlable);
		Assert.assertEquals(true, subsriptionlableele.isDisplayed());
		
    }
    public void useremailidd(String UserEnterEmailidTxt)
    {
    	WebElement Enteremailidfieldele = driver.findElement(Enteremailidfield);
    	Enteremailidfieldele.sendKeys(UserEnterEmailidTxt);
    }
    public void clickonarrowButton()
    	{
    	WebElement ArrowbuttonclickEle = driver.findElement(Arrowbuttonclick);
    	ArrowbuttonclickEle.click();
    
    	}
    public void Succesfullydone(String Successfullymessage)
    {
    	WebElement Successalertele = driver.findElement(Successalert);
		Assert.assertEquals(true, Successalertele.isDisplayed());
    }


    
    public void clickOnSignUpLoginBtn()
    {
    	WebElement signupLoginButtonEle = driver.findElement(signupLoginButton);
 	   	signupLoginButtonEle.click();
    }
    
    public void validateLogoutButtonFormHeader(String logoutButtontext)
    {
		WebElement logoutButtonEle = driver.findElement(logoutButton);
		Assert.assertEquals(logoutButtontext, logoutButtonEle.getText().trim());
    }
    
    public void validateUserNameLoggedInAs(String loggedInUserName)
    {
		WebElement loggedInUserNameTxtEle = driver.findElement(loggedInUserNameTxt);
		Assert.assertEquals(loggedInUserName, loggedInUserNameTxtEle.getText().trim());
    }
    
    public void loginbtn()
    {
    	WebElement Loginbtnele = driver.findElement(Loginbtn);
    	Loginbtnele.click();
    }
    public void Logoutbtn()
    {
    	WebElement logoutButtonele =driver.findElement(logoutButton);
    	logoutButtonele.click();
    	
    }
    
   
}
