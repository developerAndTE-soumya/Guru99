package com.qa.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ExcelReadLoginPage {

	@FindBy(name = "uid")
	private WebElement txtboxUserName;

	@FindBy(name = "password")
	private WebElement txtboxPassword;

	@FindBy(name = "btnLogin")
	private WebElement btnLogin;

	@FindBy(xpath = "//a[@href=\"Logout.php\"]")
	private WebElement btnLogOut;
	
	public ExcelReadLoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void login(String uName, String pwd) {

		txtboxUserName.sendKeys(uName);

		txtboxPassword.sendKeys(pwd);

		btnLogin.click();

	}

	public void logout() {
		btnLogOut.click();
	}
}
