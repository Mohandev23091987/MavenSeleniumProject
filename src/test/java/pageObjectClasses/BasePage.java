package pageObjectClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
	
public WebDriver driver;
	
	//constructor 
public BasePage(WebDriver driver){
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
//added new comment

//added interview statement

//added new comment

}
