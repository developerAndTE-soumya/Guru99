package com.qa.tests;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class LoginTest {//a[@href=\"Logout.php\"]
  WebDriver driver;
	
  
	  
	  @Test
		void setup() throws MalformedURLException {
			String nodeURL="http: (3rd url)     /wd/hub";
			//DesiredCapabilities are a set of key-value pairs encoded as a JSON object.
			//It helps QAs define basic test requirements such as operating systems, browser
			//combinations, browser versions, etc. within Selenium test scripts
		   DesiredCapabilities cap= DesiredCapabilities.chrome();
		   cap.setBrowserName("chrome");
			cap.setPlatform(Platform.WINDOWS);
			
			//chromeOptions defination
			ChromeOptions options= new ChromeOptions();
			options.merge(cap);
			
			//System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver_win32_10\\chromedriver.exe");
			driver= new RemoteWebDriver(new URL(nodeURL),options);
			
			driver.get("");
			System.out.println(driver.getTitle());
		}
	  
	  }
  25.00
  
  
  
	/*public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver_win32_10\\chromedriver.exe");
		//Headless browser
		//ChromeOptions options= new ChromeOptions();
		//options.addArguments("headless");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		//driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://demo.guru99.com/v4/");
		
	
		driver.findElement(By.name("uid")).sendKeys("mngr277921");
		//logger.info("username provided");
		driver.findElement(By.name("password")).sendKeys("semyhUs");
		//logger.info("password provided")
		driver.findElement(By.name("btnLogin")).click();
		
		
		if(isAlertPresent()==true) {
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent(); //- it will redirect to the main page
			Assert.assertTrue(false); // this is the failed testcase, if we get the alert then we have to accept it then page will
			    
			////be redirected to main page
			//logger.warn("LOGIN FAILED")
		}
		else {
			Assert.assertTrue(true); //this is the passed testcase
			   //logout method cALLED
			//Logger.info("Login passed")
			driver.findElement(By.xpath("//a[@href=\\\"Logout.php\\\"]"));
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
		}
  }
		public boolean isAlertPresent() { //user defined method to check alert is present or not
			try {
			   driver.switchTo().alert();
			   return true;
			}
			catch(NoAlertPresentException e) {
				return false;
			}
			
		}
		
		
	}*/

