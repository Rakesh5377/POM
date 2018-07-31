package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.CompaniesPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.ResourcesPage;
import com.crm.qa.testUtil.TestUtil;

public class HomePageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	CompaniesPage companiesPage;
	ResourcesPage resourcesPage;
	

	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		Initialization();
		loginPage = new LoginPage();
		homePage = new HomePage();
		testUtil = new TestUtil();
		homePage = loginPage.login(prop.getProperty("username"),
				prop.getProperty("password"));
	}

	@Test(priority=3)
	public void validateCompaniesLinkTest() {
		testUtil.swithToFrame();
		companiesPage = homePage.validateCompaniesLink();

	}

	@Test(priority=2)
	public void validateUserNameTest() {
		testUtil.swithToFrame();
		boolean flag = homePage.validateUserName();
		Assert.assertTrue(flag);
	}

	@Test(priority=1)
	public void validateCompaniesPageTitleTest() {
		String title = homePage.validateCompaniesPageTitle();
		Assert.assertEquals(title, "CRMPRO");
	}
	
	@Test(priority=4)
	public void mouseMovementOnCompaniesLinkTest(){
		testUtil.swithToFrame();
		homePage.mouseMovementOnCompaniesLink();
	}
	
	@Test(priority=5)
	public void verifyResourcesLinkTest(){
		testUtil.swithToFrame();
		resourcesPage = homePage.verifyResourcesLink();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
