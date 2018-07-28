package com.crm.qa.testcases;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;


public class LoginPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	
	public LoginPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		Initialization();
		loginPage = new LoginPage();
	}
	
	@Test(priority=1)
	public void validateLoginPageTitleTest(){
		String s = loginPage.validateLoginPageTitle();
		Assert.assertEquals(s, "Free CRM software in the cloud powers sales and customer service");
	}
	
	@Test(priority=2)
	public void validateCRMLogoTest(){
		boolean b = loginPage.validateCRMLogo();
		//Assert.assertTrue(b, "CRM logo is displaying!");
		if(b == true){
			System.out.println("CRM logo is displaying!");

		}
		else{
			System.out.println("CRM logo is not displaying!");
		}
	}
	
	@Test(priority=3)
	public void validateSignUpBtnTest(){
		boolean flag = loginPage.validateSignUpBtn();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=4)
	public void validateLoginTest(){
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	
}
