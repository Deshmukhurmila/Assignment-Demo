package com.assignmentdemo.stepdefs;

import java.util.List;
import static org.junit.Assert.assertTrue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.assignmentdemo.Pageobject.LandingPage;
import com.assignmentdemo.Pageobject.SignupAndLoginPage;
import com.assignmentdemo.webdriver.WebDriverfactory;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefs {
	private static final Logger logger = LogManager.getLogger(StepDefs.class);


	WebDriver driver;
	WebDriverWait wait;
	
	String baseUrl = "https://automationexercise.com/";
	int implictlyWaitTimeoutSec = 20;
	Scenario scn;
	
	LandingPage landingpage ;
	SignupAndLoginPage signupandloginpage;
	
	
	@Before
	public void setUp(Scenario scn) throws Exception
	{
		this.scn = scn;
		String browserName = WebDriverfactory.getBrowserName();
		driver = WebDriverfactory.getWebDriverForBrowser(browserName);
		wait = new WebDriverWait(driver, implictlyWaitTimeoutSec);
		
		landingpage = new LandingPage(driver);
		signupandloginpage = new SignupAndLoginPage(driver);
		
	}
	@After(order=1)
	public void cleanUp()
	{
		WebDriverfactory.quitDriver();
		scn.log("Browser got closed");
		logger.info("Browser got closed");
	}
	
	@After(order=2) // this will execute first, higher the number, sooner it executes
	  public void takeScreenShot(Scenario s) {
	    if (s.isFailed()) {
	        TakesScreenshot scrnShot = (TakesScreenshot)driver;
	        byte[] data = scrnShot.getScreenshotAs(OutputType.BYTES);
	        scn.attach(data, "image/png","Failed Step Name: " + s.getName());
	    }else{
	        scn.log("Test case is passed, no screen shot captured");
	    }
	  }
	//***************@ValidationOflandingpageElement****************
	
	@Given("user navigate to the home application url")
	public void user_navigate_to_the_home_application_url() {
		WebDriverfactory.navigateToTheUrl(baseUrl);
	}
	

		@When("user header over to Home Page")
		public void user_header_over_to_home_page() {
			landingpage.Validatingheaderbtns();
		}

		@Then("Options underheader section")
		public void options_underheader_section(List<String> expectedElementTexts)
		{
			
		        List<WebElement> elements = driver.findElements(By.xpath("//ul[@class='nav navbar-nav']/li[a]"));

		        for (int i = 0; i < expectedElementTexts.size(); i++) {
		            String actualText = elements.get(i).getText();
		            String expectedText = expectedElementTexts.get(i);
		            assertTrue("Element text mismatch at index " + i, actualText.contains(expectedText));
		        
		        }
		}
			

	//*****************@ValidationOflandingpageElement************************
	
	//*****************SUBSRIPTION *****************
	
	
			@Given("User see SUBSCRIPTION Lable")
			public void user_see_subscription_lable() {
				landingpage.validateSUBSCRIPTIONlablefooter();
			}
			
			@When("User enter email id {string}")
			public void user_enter_email_id(String UserEnterEmailidTxt) 
			{
			   landingpage.useremailidd(UserEnterEmailidTxt);
			}
			 @When("Click on Arrow button")
			    public void click_on_arrow_button() {
			    landingpage.clickonarrowButton();
			    }
			 
			  @Then("Validate User has {string}")
			 public void validate_user_has(String Successfullymessage) {
				 landingpage.Succesfullydone(Successfullymessage);
			 }
			
			 
	//*****************SUBSRIPTION *****************
		
	//*****************ErrorMessage*****************//

			  
				  @Given("User Navigate to Login Page")
				  public void user_navigate_to_login_page() {
					  landingpage.clickOnSignUpLoginBtn();
				  }
				  @When("user enters email id as {string}")
				  public void user_enters_email_id_as(String username) 
				  {
					  signupandloginpage.ErrormsgEnterUsername(username);
				  }
				  @When("user enters password as {string}")
				  public void user_enters_password_as(String Password) 
				  {
					  signupandloginpage.ErrormsgEnterPassword(Password);
				  }
				  @When("checking click on login button")
				  public void checking_click_on_login_button() 
				  {
					  landingpage.loginbtn();
				  }
				  @Then("Validation of  Error message {string}")
				  public void validation_of_error_message(String message) {
					  signupandloginpage.Validatingerrormsg(message);
				  }
		  

//*****************ErrorMessage*****************//


			 	
	
	//***************** Sign up\\/login ************************

	@Given("user clicks on Signup\\/login button form top header section")
	public void user_clicks_on_signup_login_button_form_top_header_section()
	{
		landingpage.clickOnSignUpLoginBtn();
	}
	
	@When("user redirected to login page with title as {string}")
	public void user_redirected_to_login_page_with_title_as(String loginPageTitle) {
		signupandloginpage.validatesignUpLoginPageTitle(loginPageTitle);
	}
	@When("url for the login page contains {string} as keyword")
	public void url_for_the_login_page_contains_as_keyword(String loginPageUrlKeyword) {
		signupandloginpage.validateLoginKeywordInUrl(loginPageUrlKeyword);
	}
	@When("user able to see {string} section on login page")
	public void user_able_to_see_section_on_login_page(String loginPageSecHeader) {
		signupandloginpage.validateLoginSectionHeader(loginPageSecHeader);   
	}
	@When("user enters valid registered email id as {string}")
	public void user_enters_valid_registered_email_id_as(String userRegEmailIDtxt) {
		signupandloginpage.sendTextToLoginField(userRegEmailIDtxt);
	}
	@When("user enters valid password as {string}")
	public void user_enters_valid_password_as(String userRegPasswordtxt) {
		signupandloginpage.sendTextToPasswordField(userRegPasswordtxt);
	}	
			

	@When("click on login button")
	public void click_on_login_button() {
		landingpage.loginbtn();
		
	}
		
	@Then("after login user able to see {string} button at top header of application")
	public void after_login_user_able_to_see_button_at_top_header_of_application(String logoutButtontext) {
		landingpage.validateLogoutButtonFormHeader(logoutButtontext);
	}
	
	@Then("with {string} as user name just after Logged in as button")
	public void with_as_user_name_just_after_logged_in_as_button(String loggedInUserName) {
		landingpage.validateUserNameLoggedInAs(loggedInUserName);
	}
	@Then("click on logout")
	public void click_on_logout() {
	   
	}
}
//***************** Sign up\\/login ************************
	





