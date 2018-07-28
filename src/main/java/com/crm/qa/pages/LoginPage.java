package com.crm.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {

	// Page Factory - OR
	@FindBy(name = "username")
	WebElement username;

	@FindBy(name = "password")
	WebElement password;

	@FindBy(xpath = "//input[@type='submit' and @value='Login']")
	WebElement loginBtn;

	@FindBy(xpath = "//img[@class='img-responsive' and @alt='free crm logo']")
	WebElement crmLogo;

	@FindBy(xpath = "//button[@type='button' and contains(text(),'Sign Up')]")
	WebElement signUpBtn;

	// Initialization of Page Objects
	public LoginPage() {
		PageFactory.initElements(driver, this);

	}

	//Actions
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}

	public boolean validateCRMLogo() {
		return crmLogo.isDisplayed();
	}

	public boolean validateSignUpBtn() {
		return signUpBtn.isDisplayed();
	}

	public HomePage login(String un, String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
		//loginBtn.click();
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", loginBtn);
			
			
		return new HomePage();
	}
}
