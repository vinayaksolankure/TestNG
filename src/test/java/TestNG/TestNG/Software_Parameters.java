package TestNG.TestNG;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Software_Parameters {
  @Test
  @Parameters({"SoftwareName"})
  public void testCase1(String name) {
	  System.out.println(name);
  }
}
