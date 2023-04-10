package RetryLogicDemo;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCaseExmple {
	
	@Test
	public void TestCase01()
	{
		Assert.assertTrue(false); //Test case will fail
	}
	
	@Test
	public void TestCase02()
	{
		Assert.assertTrue(false); //Test case will fail
	}
	
	@Test
	public void TestCase03()
	{
		Assert.assertTrue(true); //Test case will fail
	}
}
