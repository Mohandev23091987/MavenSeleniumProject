package testScripts;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import org.testng.annotations.Test;


import pageObjectClasses.HomePageClass;
import pageObjectClasses.LoginPageClass;



public class HomeTests extends BaseTest {

	

	@Test(priority=1,groups={"Regression"})
	void VerifyHomeButton() throws InterruptedException {
		LoginPageClass loginobj = new LoginPageClass(driver);
		HomePageClass homepageObj = new  HomePageClass(driver);
		loginobj.enterUserName(resoruceBandleObj.getString("username"));
		loginobj.enterPwd(resoruceBandleObj.getString("password"));
		loginobj.clickOnLoginButton();
		homepageObj.waitUntilVisibliityOfElement();
		String text = homepageObj.getWelcomeText();
		
		Assert.assertEquals(text.contains("Rahul Shetty"), true, "not matching Actual text is"+ text);
						
	}
	
	@Test(priority=2,groups={"Regression","Smoke","Sanity","P1","S1","Logout","ABDCD"})
	void perfromLogout() {
		HomePageClass homepageObj = new  HomePageClass(driver);
		homepageObj.clickOnLogoutButton();		
			
	}
	


}
