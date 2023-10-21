package testScripts;


import org.testng.Assert;

import org.testng.annotations.Test;

import pageObjectClasses.HomePageClass;
import pageObjectClasses.LoginPageClass;

public class LoginTests extends BaseTest {
	
	@Test(priority=1,groups= {"Regression","Smoke","Sanity"})
	void login() {
		LoginPageClass loginobj = new LoginPageClass(driver);
		HomePageClass homepageObj = new  HomePageClass(driver);
		try {
		logger.debug("Event logging for Application");
		logger.info("This is a login Test");
		logger.info("Testcase execution is starting");
		loginobj.enterUserName("Mohan");
		logger.info("Entered Username as: "+"MOhan");
		loginobj.enterPwd("rahulshettyacademy");
		logger.info("Entered pwd as: "+"rahulshettyaca");
		loginobj.clickOnLoginButton();
		logger.info("Clicked on login button");
		homepageObj.clickOnLogoutButton();
		
		}
		catch(Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
			
	}
	
	@Test(priority=2,groups={"Regression"})
	void loginwithWrongCredentails() {
		LoginPageClass loginobj = new LoginPageClass(driver);
		String expectedError = "* Incorrect username or password";
		try {
		loginobj.enterUserName("Mohan");
		logger.info("Entered Username as: "+"MOhan");
		loginobj.enterPwd("kjlkjkl");
		logger.info("Entered pwd as: "+"kjlkjkl");
		loginobj.clickOnLoginButton();
		logger.info("Clicked on login button");
		
		
		String actualErrorText = loginobj.getErrorText(); 
		logger.info("Error text is "+actualErrorText);
		Assert.assertEquals(actualErrorText, expectedError,"Error message is not correct");
		}
		catch(Exception e) {
			e.printStackTrace();
			logger.error("Got an error");
			Assert.fail();
		}
			
	}
	

}
