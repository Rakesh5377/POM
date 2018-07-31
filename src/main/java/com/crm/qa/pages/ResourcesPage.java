package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class ResourcesPage extends TestBase {

	@FindBy(xpath = "//td[contains(text(),'Company Resources')]")
	WebElement resourcesLabel;

	public ResourcesPage() {
		PageFactory.initElements(driver, this);
	}

	public boolean verifyResourcesLabel(){
		
		return resourcesLabel.isDisplayed();
	
	}
}
