package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class CompaniesPage extends TestBase {

	@FindBy(xpath = "//td[contains(text(),'Companies')]")
	WebElement companyLabel;
	
	@FindBy(name = "company_name")
	WebElement companyName;
	
	@FindBy(name = "industry")
	WebElement industryName;
	
	@FindBy(xpath = "//*[@id='companyForm']/table/tbody/tr[1]/td/input")
	WebElement saveBtn;
	
	public CompaniesPage(){
		PageFactory.initElements(driver, this);
	}
	
	public boolean validateCompanyLabel(){
		return companyLabel.isDisplayed();
	}
	
	public void createNewCompany(String comp, String industry){
		companyName.sendKeys(comp);
		industryName.sendKeys(industry);
		saveBtn.click();
	}
	
}
