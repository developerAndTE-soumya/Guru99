package com.qa.tests;

import java.lang.reflect.Method;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.qa.utilities.PropertyUtil;

  public class BaseTest {
  public WebDriver driver;
 
    @BeforeSuite
    public void initialize() {
    	DOMConfigurator.configure("log4j.xml");
    }
    
    @BeforeMethod
    public void openBrowser(Method method) {
    String browserName=	PropertyUtil.readProperty("browserName");
    }
    
}
