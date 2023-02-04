package testcases;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class BaseTest {

	public WebDriver driver;

	FileInputStream fis;
	Properties config;

	public ExtentSparkReporter extentSpartReporter;
	public ExtentReports extentReports;
	public ExtentTest extentTest;

	@BeforeSuite
	public void config() throws IOException {
		config = new Properties();

		fis = new FileInputStream("src/test/resources/config/config.properties");
		config.load(fis);

		if (extentReports == null) {
			extentSpartReporter = new ExtentSparkReporter("reports/AutomationReport.html");
			extentReports = new ExtentReports();
			extentReports.attachReporter(extentSpartReporter);
			
			extentReports.setSystemInfo("App URL", config.getProperty("applicationUrl"));
			extentReports.setSystemInfo("Browser", config.getProperty("browser"));
			extentReports.setSystemInfo("OS", "Windows 11");
			extentReports.setSystemInfo("Environment", "QA");
			
			extentSpartReporter.config().setReportName("Hospital Management Automation Report");
			extentSpartReporter.config().setDocumentTitle("HMA Report");
			extentSpartReporter.config().setTheme(Theme.DARK);			
		}
	}

	@AfterSuite
	public void afterSuite() {
		extentReports.flush();
	}

	@BeforeMethod
	public void beforeMethod() {

		String browser = config.getProperty("browser");

		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else {
			driver = new EdgeDriver();
		}

		driver.manage().window().maximize();
		String appURL = config.getProperty("applicationUrl");
		driver.get(appURL);
	}

	@AfterMethod
	public void afterMethod(ITestResult result) throws InterruptedException, IOException {

		if (result.getStatus() == ITestResult.SUCCESS) {
			extentTest.pass("Test Case Passed...");
		} else if (result.getStatus() == ITestResult.FAILURE) {
			extentTest.fail("Test Case Failed...");
			extentTest.fail(result.getThrowable());
			String path = captureScreenshot(result.getMethod().getMethodName());
			extentTest.fail(MediaEntityBuilder.createScreenCaptureFromPath(path).build());
		} else {
			extentTest.skip("Test Case Skipped");
		}

		Thread.sleep(3000);
		driver.quit();
	}
	
	public String captureScreenshot(String screenshotName) throws IOException {
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String dest = "D:/Work/eclipse-workspace/SeleniumFrameworkDec2023Batch/screenshots/" +screenshotName+".png";
		File destination = new File(dest);
		FileHandler.copy(source, destination);
		return dest;
	}
}