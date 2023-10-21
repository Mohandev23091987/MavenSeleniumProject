package pageObjectClasses;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePageClass extends BasePage {
	

public HomePageClass(WebDriver driver){
		super(driver);
	}
	
	
	//locators

	
	@FindBy(xpath ="//*[@id='root']/div/div/div/button")
	private WebElement logoutButton;
	
	@FindBy(xpath ="//h1[contains(text(),'Welcome to')]")
	private WebElement welcomeText;
	
	
	
	
	
	//methods 
	public void clickOnLogoutButton() {
		logoutButton.click();		
	}
	
	public String getWelcomeText() {
		return welcomeText.getText();		
	}
	
	public void waitUntilVisibliityOfElement() {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(welcomeText));
	}
	
	



}
