package pageObjectClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginPageClass extends BasePage {
	

	public LoginPageClass(WebDriver driver){
		super(driver);
	}
	
	
	//locators
	@FindBy(xpath ="//input[@id='inputUsername']")
	private WebElement username;
	
	@FindBy(xpath ="//input[@name='inputPassword']")
	private WebElement password;
	
	@FindBy(xpath ="//button[text()='Sign In']")
	private WebElement loginButton;
	
	@FindBy(xpath ="//p[@class='error']")
	private WebElement errorMsg;
	
	
	
	
	
	
	
	
	//methods 
	
	public void enterUserName(String userName) {
		username.sendKeys(userName);
		
	}
	
	public void enterPwd(String pwd) {
		password.sendKeys(pwd);
		
	}
	
	public void clickOnLoginButton() {
		loginButton.click();
		
	}
	
	public void clearUsername() {
		username.clear();
		
	}
	
	public void clearPwd() {
		password.clear();
		
	}
	
	public String getErrorText() {
		return errorMsg.getText(); 
		
	}
	
	
	
	
	
	

}
