package ExtentReportTestNGListenerDemo;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportListenerClass implements ITestListener{
	
	ExtentSparkReporter htmlReporter;
	ExtentReports reports;
	ExtentTest test;
	
	public void configureReport()
	{
		htmlReporter = new ExtentSparkReporter("E:\\OneDrive\\Desktop\\DemoTest\\Eclipse Workspace\\DemoTestMavenProject\\TestNG\\src\\test\\java\\ExtentReportTestNGListenerDemo\\ExtentReportListener.html");
		reports = new ExtentReports();
		reports.attachReporter(htmlReporter);

		// add environment details
		reports.setSystemInfo("Machine", "testPC1");
		reports.setSystemInfo("OS", "Windows 10");
		reports.setSystemInfo("User", "Vinayak");
		reports.setSystemInfo("Browser", "Chrome");

		// Configuration to change look and feel
		htmlReporter.config().setDocumentTitle("Extent Report Listener Demo");
		htmlReporter.config().setReportName("This is my Test Report for extent reort listener demo.");
		htmlReporter.config().setTheme(Theme.DARK);
		htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
	}
	
	public void onStart(ITestContext context) {
		configureReport();
		System.out.println("On start method invoked...");
	}

	public void onFinish(ITestContext context) {
		System.out.println("On Finish method invoked...");
		reports.flush();
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("Name of Failed test method: " + result.getName());
		test = reports.createTest(result.getName());
		test.log(Status.FAIL, MarkupHelper.createLabel("Name of the failed test case is: " + result.getName(), ExtentColor.RED));
		test.fail(result.getThrowable());
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("Name of Skipped test method: " + result.getName());
		test = reports.createTest(result.getName());
		test.log(Status.SKIP, MarkupHelper.createLabel("Name of the skipped test case is: " + result.getName(), ExtentColor.YELLOW));
	}
 
	public void onTestStart(ITestResult result) {
		System.out.println("Name of Started test method: " + result.getName());
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("Name of Successfully executed test method: " + result.getName());
		test = reports.createTest(result.getName());
		test.log(Status.PASS, MarkupHelper.createLabel("Name of the passed test case is: " + result.getName(), ExtentColor.GREEN));
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// not implemented
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		//onTestFailure(result);
	}
}
