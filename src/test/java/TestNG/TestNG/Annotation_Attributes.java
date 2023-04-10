package TestNG.TestNG;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Annotation_Attributes {

	//@Test(description = "This is test case 1.")
	//@Test(priority = 1)
	//@Test(dependsOnMethods = {"testCase2","testCase3"})
	@Test(enabled = false)
	public void testCase1() {
		System.out.println("Mobile Login TestCase.");
	}

	//@Test(description = "This is test case 2.")
	//@Test(timeOut = 200)
	//@Test(priority = 2)
	@Test
	public void testCase2() {
//		try {
//			Thread.sleep(400);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		System.out.println("Web Login TestCase.");
		//Assert.assertTrue(false);   // This is for method failing
	}

	//@Test(description = "This is test case 3.")
	//@Test(priority = 3)
	@Test
	public void testCase3() {
		System.out.println("API Login TestCase.");
	}
}
