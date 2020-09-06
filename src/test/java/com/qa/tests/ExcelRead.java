package com.qa.tests;

import java.io.IOException;
import java.sql.Driver;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.utilities.ExcelUtil;

public class ExcelRead{
     WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		//driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://demo.guru99.com/v4/");
		
	}
	
	@Test(dataProvider="LoginData")
	public void login(String uName,String pwd) {
		ExcelReadLoginPage ip=new ExcelReadLoginPage(driver);
		ip.login(uName, pwd);
		
		if(isAlertPresent()==true) {
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent(); //- it will redirect to the main page
			Assert.assertTrue(false); // this is the failed testcase, if we get the alert then we have to accept it then page will
			                          //be redirected to main page
		}
		else {
			Assert.assertTrue(true); //this is the passed testcase
			   //logout method cALLED
			ip.logout();
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
	
	@DataProvider(name="LoginData")
     String[][] getData() throws IOException{
	String path="E:\\practiceForInterview\\WorkSpace\\Guru99\\src\\test\\resources\\TestData\\guru99.xlsx";
	
	int rownum= ExcelUtil.getRowCount(path, "Sheet1");
	int colcount=ExcelUtil.getCellCount(path, "Sheet1", 1);
	
	String logindata[][]= new String[rownum][colcount];
	
	for(int i=1;i<=rownum;i++) {
		for(int j=0;j<colcount;j++) {
			
		
		logindata[i-1][j]=ExcelUtil.getCellData(path, "Sheet1", i, j);
	}
	
	}return logindata;
	
	
	}
}
