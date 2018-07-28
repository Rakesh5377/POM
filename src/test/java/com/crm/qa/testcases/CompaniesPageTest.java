package com.crm.qa.testcases;

import org.junit.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.CompaniesPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.testUtil.TestUtil;

public class CompaniesPageTest extends TestBase {

	LoginPage loginPage;
	TestUtil testUtil;
	HomePage homePage;
	CompaniesPage companiesPage;
	
	String sheetName = "companies";

	public CompaniesPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		Initialization();
		testUtil = new TestUtil();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"),
				prop.getProperty("password"));
		testUtil.swithToFrame();
		companiesPage = homePage.validateCompaniesLink();
		
	}

	@Test(priority=1)
	public void validateCompaniesLabel() {
		//testUtil.swithToFrame();
		boolean flag = companiesPage.validateCompanyLabel();
		Assert.assertTrue(flag);
	}
	
	@DataProvider
	public Object[][] getCRMTestData(){
		Object data [][] = TestUtil.getTestData(sheetName);
		return data;
		
	}
	
	@Test(priority=2, dataProvider="getCRMTestData")
	public void newCompanyTest(String company, String industry){
		homePage.mouseMovementOnCompaniesLink();
		//companiesPage.createNewCompany("oracle","IT Industry");
		companiesPage.createNewCompany(company, industry);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
