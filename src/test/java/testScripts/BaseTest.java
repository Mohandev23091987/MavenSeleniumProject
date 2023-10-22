package testScripts;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

//this is a basetest
public class BaseTest {
	
	public static WebDriver driver;
	
	public Logger logger;
	
	public ResourceBundle resoruceBandleObj;
	
	@BeforeClass(groups= {"Regression","Smoke","Sanity"})
	@Parameters({"browser"})
	public void setup(String browserName) {
		resoruceBandleObj= ResourceBundle.getBundle("config");
		logger= LogManager.getLogger(this.getClass());
		if(browserName.equalsIgnoreCase("chrome")) {
		 driver = new ChromeDriver();
		}else if(browserName.equalsIgnoreCase("firefox")) {
			 driver = new FirefoxDriver();
		} else if(browserName.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}
		
		
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(resoruceBandleObj.getString("appliationURL"));
		driver.manage().window().maximize();	
	}
	

	@AfterClass(groups= {"Regression","Smoke","Sanity"})
	public void tearDown() {
		driver.quit();	
	}
	
	public String takeScreenshot(String testName) throws IOException {
		
		String timeStamp= new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		
		TakesScreenshot screenshot = (TakesScreenshot)driver;
		File source = screenshot.getScreenshotAs(OutputType.FILE);
		
		String destinationFolder = System.getProperty("user.dir")+"\\screenshots\\"+testName+timeStamp+".png";
		
		try {
		FileUtils.copyFile(source, new File(destinationFolder));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return destinationFolder;
		
		
		
		///comment is added
		
		//adding this line to the git hub
	}

}
