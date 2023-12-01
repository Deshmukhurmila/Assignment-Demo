package com.assignmentdemo.Pageobject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LandingPage {
	
	
	//private static final Logger logger = LogManager.getLogger(LandingPage.class);
	
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
    private By Validatingheaderbtns = By.xpath("//ul[@class='nav navbar-nav']");
    private By Loginbtn = By.xpath("//button[@class='btn btn-default']");
    private By Successalert =By.xpath("//div[@class='alert-success alert']");
  
   // Page Methods
    
    public void Validatingheaderbtns()
    {
    	WebElement ValidatingheaderbtnsEle = driver.findElement(Validatingheaderbtns);
	    Assert.assertEquals(true, ValidatingheaderbtnsEle.isDisplayed());
	    
   }
    
  //SUBSRIPTION 
    public void validateSUBSCRIPTIONlablefooter()
    {
		WebElement subsriptionlableele = driver.findElement(subsriptionlable);
		Assert.assertEquals(true, subsriptionlableele.isDisplayed());
		
    }public void useremailidd(String UserEnterEmailidTxt)
    {
    	WebElement Enteremailidfieldele = driver.findElement(Enteremailidfield);
    	Enteremailidfieldele.sendKeys(UserEnterEmailidTxt);
    }
    public void clickonarrowButton()
    	{
    	WebElement ArrowbuttonclickEle = driver.findElement(Arrowbuttonclick);
    	ArrowbuttonclickEle.click();
    
    	}
    
    public void Succesfullydone()
    {
    	WebElement Successalertele = driver.findElement(Successalert);
		Assert.assertEquals(true, Successalertele.isDisplayed());
    }
    //SUBSRIPTION 

    
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
