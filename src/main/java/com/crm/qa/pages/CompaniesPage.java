package com.crm.qa.pages;

import org.openqa.selenium.Alert;
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
	
	@FindBy(xpath = "//*[@id='vCompaniesForm']/table/tbody/tr[4]/td[1]/input")
	WebElement selectAllCheckBox;
	
	@FindBy(xpath = "//input[@value='Delete Checked']")
	WebElement deleteChecked;
	
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
	
	public void selectAllAndDelete(){
		selectAllCheckBox.click();
		deleteChecked.click();
		Alert alert = driver.switchTo().alert();
		alert.getText();
		alert.accept();
	}
	
	
	
}
