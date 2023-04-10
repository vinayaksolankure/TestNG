package TestNG.TestNG;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Annotations {
	
	@BeforeSuite
	public void beforesuite() {
		System.out.println("Before suite.....\n");
	}
	
	@AfterSuite
	public void aftersuite() {
		System.out.println("after suite.....");
	}
	
	@BeforeTest
	public void beforetest() {
		System.out.println("Before test.....\n");
	}
	
	@AfterTest
	public void aftertest() {
		System.out.println("after test.....\n");
	}
	
	@BeforeClass
	public void beforeclass() {
		System.out.println("Before class.....\n");
	}
	
	@AfterClass
	public void afterclass() {
		System.out.println("After Class.....\n");
	}
	
	@BeforeMethod
	public void beforemethod() {
		System.out.println("before method.....");
	}
	
	@AfterMethod
	public void aftermethod() {
		System.out.println("after method.....\n");
	}
	
	@Test
	public void test1() {
		System.out.println("This is test1........");
	}

	@Test
	public void test2() {
		System.out.println("This is test2........");
	}
	
	
}
