package TestNG.TestNG;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Automobile_Parameters {
  @Test
  @Parameters({"AutoMobileName"})
  public void testCase1(String name) {
	  System.out.println(name);
  }
}
