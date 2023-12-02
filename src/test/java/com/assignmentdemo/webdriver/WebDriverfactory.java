package com.assignmentdemo.webdriver;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverfactory {
	
	private static final Logger logger = LogManager.getLogger(WebDriverfactory.class);
				
	    private static WebDriver driver=null;
	   
	    public static WebDriver getWebDriverForBrowser(String browser) throws Exception {
	        switch(browser.toLowerCase())
	        {
	            case "chrome":
	            	System.setProperty("webdriver.chrome.driver","C:\\Users\\User\\eclipse-workspace\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
	        		logger.info("Setting up for browser path is completed");
	        		ChromeOptions opt = new ChromeOptions();
	        		opt.setBinary("C:\\Users\\User\\eclipse-workspace\\chrome-win64\\chrome-win64\\chrome.exe");
	        		logger.info("Setting up chrome binary completed");
	        		driver = new ChromeDriver(opt);
	                logger.info("Chrome Browser invoked"); 
	                break;
	            case "edge":
	            	WebDriverManager.edgedriver().setup();
	            	driver = new EdgeDriver();
	                logger.info("Opera Browser invoked");
	                break;
	            
	        }

	        driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	        logger.info("Driver maximized and implicit time out set to 20 seconds");
	        return driver;
	        
	    }
	    public static void navigateToTheUrl(String Url)
	    {
	        driver.get(Url);
	        logger.info("Browser navigated to the url: " + Url);
	    }

	    public static void quitDriver(){
	        driver.quit();
	        logger.info("Driver closed");
	        
	    }
	   
	    

		public static String getBrowserName() {
			  String browserDefault = "chrome"; //Set by default
		        String browserSentFromCmd = System.getProperty("browser");

		        if (browserSentFromCmd==null){
		            return browserDefault;
		        }else{
		            return browserSentFromCmd;
		        }
		}

	}
	
	
	
	
	
	
	
	


