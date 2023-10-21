package Utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testScripts.BaseTest;

public class ExtentReportsClass implements ITestListener {
	

	

	
	public ExtentSparkReporter sparkReporter;  
	public ExtentReports extent;  
	public ExtentTest extenttest; 
	
	public void onStart(ITestContext context) {
		 //template of the report document
		
		String timeStamp= new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		
		sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir")+ "/reports/"+timeStamp+".html"); 
		
		sparkReporter.config().setDocumentTitle("Rahul Shetty");
		sparkReporter.config().setReportName("Regression");
		sparkReporter.config().setTheme(Theme.STANDARD);
		
		extent=new ExtentReports();
		extent.attachReporter(sparkReporter);
		extent.setSystemInfo("ApplictionName","Rahul Shetty");
		extent.setSystemInfo("Environment","QA");
		extent.setSystemInfo("Tester Name","MOhan");
		extent.setSystemInfo("OS","Windows");
		extent.setSystemInfo("Browser name","Chrome");
					  
		  }
	
  
	  public void onTestSuccess(ITestResult result) {
		  extenttest = extent.createTest(result.getName());
		  extenttest.log(Status.PASS, "Test case PASSED is:" + result.getName());	   
		  }
	  
	  public void onTestFailure(ITestResult result) {
		  extenttest = extent.createTest(result.getName());
		  extenttest.log(Status.FAIL,"Test Case FAILED cause is: "+ result.getThrowable());
		  try {
		  String screenShot = new BaseTest().takeScreenshot(result.getName());
		  extenttest.addScreenCaptureFromPath(screenShot);
		  }
		  catch(Exception e) {
			  e.printStackTrace();
			  e.getMessage();  
		  }
		  }
	  
	  public void onTestSkipped(ITestResult result) {
		  extenttest = extent.createTest(result.getName());
		  extenttest.log(Status.SKIP, "Test case SKIPPED is:" + result.getName());
		    
		  }
	  public void onFinish(ITestContext context) {
//save the report 
		  //publish
		  extent.flush();
		  }




}
