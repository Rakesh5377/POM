package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {

	//Page Factory or OR
	@FindBy(xpath = "//a[@title='Companies']")
	WebElement companiesLink;
	
	@FindBy(xpath = "//td[contains(text(),'Rakesh Tiwari')]")
	WebElement userName;
	
	@FindBy(xpath = "//a[@title='New Company']")
	WebElement clickOnNewCompanyLink;
	
	@FindBy(xpath="//a[@title='Resources']")
	WebElement resourcesLink;
	
	
	public HomePage(){
		PageFactory.initElements(driver, this);
	}
	
	public CompaniesPage validateCompaniesLink(){
		companiesLink.click();
		return new CompaniesPage();
	}
	
	public boolean validateUserName(){
		return userName.isDisplayed();
	}

	public String validateCompaniesPageTitle(){
		String s = driver.getTitle();
		return s;
	}
	
	public void mouseMovementOnCompaniesLink(){
		Actions action = new Actions(driver);
		action.moveToElement(companiesLink).build().perform();
		clickOnNewCompanyLink.click();
	
	}
	
	public ResourcesPage verifyResourcesLink(){
		resourcesLink.click();
		return new ResourcesPage();
	}
	
	
}
