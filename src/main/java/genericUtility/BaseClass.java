package genericUtility;

import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class BaseClass {
	public WebDriver driver;
	public JavaUtility jlib=new JavaUtility();
	public FileUtility flib=new FileUtility();
	public ExtentReports report;
	public ExtentTest test;
	
	@BeforeSuite
	public void reportConfig() {
		String fileName = jlib.getFileName();
		ExtentSparkReporter spark=new ExtentSparkReporter("./Html_Report/"+fileName+".html");
		report=new ExtentReports();
		report.attachReporter(spark);
	}
	@Parameters("Browser")
	@BeforeClass
	public void browserSetup( @Optional("chrome") String browser) {
		
		switch(browser) {
		case "firefox" :
			driver=new FirefoxDriver();
			break;
		case "edge" :
			driver=new EdgeDriver();
			break;
		default :
			driver=new ChromeDriver();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		
		
	}
	
	@BeforeMethod
	public void initiateReport(Method method) throws IOException {
		test=report.createTest(method.getName());
		test.log(Status.INFO, "Browser is launched successfully");
		String url = flib.readDataFromPropertyfile("Url");
		driver.get(url);
	}
	
	
	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}
	
	@AfterSuite
	public void reportBackup() {
		report.flush();
	}
	

}
