package TestNG.TestNG;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenersClass implements ITestListener{

	public void onStart(ITestContext context) {
		System.out.println("On start method invoked...");
	}

	public void onFinish(ITestContext context) {
		System.out.println("On Finish method invoked...");
	}
	
	public void onTestFailure(ITestResult result) {
		System.out.println("Name of Failed test method: " + result.getName());
	}
	
	public void onTestSkipped(ITestResult result) {
		System.out.println("Name of Skipped test method: " + result.getName());
	}
	
	public void onTestStart(ITestResult result) {
		System.out.println("Name of Started test method: " + result.getName());
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("Name of Successfully executed test method: " + result.getName());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// not implemented
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		//onTestFailure(result);
	}

}
