package myTestNG;
import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class BaseClass {
	public static WebDriver driver=null;
	ExtentSparkReporter htmlReporter;
	ExtentReports reports;
	ExtentTest test;
	@BeforeTest
	public void configureReport() 
	{
		htmlReporter=new ExtentSparkReporter("ExtentReportTest");
		reports= new ExtentReports();
		reports.attachReporter(htmlReporter);
		//environment Setup
		reports.setSystemInfo("Os","Window10");
		reports.setSystemInfo("Browser","Chrome");
		reports.setSystemInfo("User","Tester - Kiran");
		reports.setSystemInfo("Environment","Qa");

		htmlReporter.config().setTimeStampFormat("EEEE,MMMM dd,yyyy,hh:mm a '('zzz')'");
	}


	@BeforeMethod
	public void lunchBrowser() 
	{
		ChromeOptions option= new ChromeOptions();
		option.setExperimentalOption("excludeSwitches",Arrays.asList("enable-automation","disable-popup-blocking"));
		option.setBrowserVersion("116");
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("credentials_enable_service", false);
		prefs.put("profile.password_manager_enabled", false);
		option.setExperimentalOption("prefs", prefs);
		driver=new ChromeDriver(option);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
		driver.manage().window().maximize();
		driver.get("http://www.automationpractice.pl/index.php");

	}
	@AfterMethod
	public void getTestResult(ITestResult result) 
	{
		if (result.getStatus()==ITestResult.FAILURE) 
		{
			test.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+"FAIL", ExtentColor.RED));
			test.fail(result.getThrowable());

		}
		else if (result.getStatus()==ITestResult.SUCCESS) 
		{
			test.log(Status.PASS, MarkupHelper.createLabel(result.getName()+"PASS", ExtentColor.GREEN));

		}
		else if (result.getStatus()==ITestResult.SKIP) 
		{
			test.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+"SKIP", ExtentColor.BROWN));
		}
	}
	@AfterTest
	public void tearDown()
	{

		reports.flush();

	}
	@AfterMethod
	public void closeBrowser() 
	{
		driver.quit();
	}

}
