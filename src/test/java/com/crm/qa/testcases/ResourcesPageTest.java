package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.ResourcesPage;
import com.crm.qa.testUtil.TestUtil;

public class ResourcesPageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	ResourcesPage resourcesPage;
	TestUtil testUtil;
	
	
	
	public ResourcesPageTest(){
		super();
		
	}
	
	@BeforeMethod
	public void setUp(){
		Initialization();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		testUtil = new TestUtil();
		testUtil.swithToFrame();
		homePage.verifyResourcesLink();
		resourcesPage = new ResourcesPage();
		
		
	}
	
	
	@Test(priority=1)
	public void validateResourcesLabelTest(){
		
		boolean flag = resourcesPage.verifyResourcesLabel();
		Assert.assertTrue(flag, "Validated resources label");
		
		
	}
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	
	
}
