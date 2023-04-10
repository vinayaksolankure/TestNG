package ExtentReportDemo;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class BasicExtentReportClass {

	ExtentSparkReporter htmlReporter;
	ExtentReports reports;
	ExtentTest test;

	@BeforeTest
	public void startReport()
	{
		htmlReporter = new ExtentSparkReporter("ExtentReportDemo.html");
		reports = new ExtentReports();
		reports.attachReporter(htmlReporter);

		// add environment details
		reports.setSystemInfo("Machine", "testPC1");
		reports.setSystemInfo("OS", "Windows 10");
		reports.setSystemInfo("User", "Vinayak");
		reports.setSystemInfo("Browser", "Chrome");

		// Configuration to change look and feel
		htmlReporter.config().setDocumentTitle("Extent Report Demo");
		htmlReporter.config().setReportName("Test Report");
		htmlReporter.config().setTheme(Theme.STANDARD);
		htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");

	}

	@Test
	public void launchBrowserAndOpenUrl()
	{
		// Create Test
		test = reports.createTest("Lauch Browser and open URL.");
		Assert.assertTrue(true); // Test will pass.
	}

	@Test
	public void verifyTitle()
	{
		// Create Test
		test = reports.createTest("Verify Title.");
		Assert.assertTrue(false); // Test will fail.
	}

	@Test
	public void verifyLogo()
	{
		// Create Test
		test = reports.createTest("Verify Logo.");
		Assert.assertTrue(true); // Test will pass.
	}

	@Test
	public void verifyEmail()
	{
		// Create Test
		test = reports.createTest("Verify Email.");
		throw new SkipException("skipping this test case with exception.....");
	}

	@Test
	public void verifyUsername()
	{
		// Create Test
		test = reports.createTest("Verify Username.");
		Assert.assertTrue(true); // Test will pass.
	}

	@AfterMethod
	public void getTestResult(ITestResult result) 
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " FAIL ", ExtentColor.RED));
			test.fail(result.getThrowable());
		}
		else if(result.getStatus()==ITestResult.SUCCESS)
		{
			test.log(Status.PASS, MarkupHelper.createLabel(result.getName() + " PASS ", ExtentColor.GREEN));
		}
		else if(result.getStatus()==ITestResult.SKIP)
		{
			test.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " SKIPPED ", ExtentColor.YELLOW));
		}
	}
	
	@AfterTest
	public void tearDown()
	{
		reports.flush();
	}
}
