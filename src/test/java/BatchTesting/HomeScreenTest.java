package BatchTesting;

import org.testng.annotations.Test;

public class HomeScreenTest {
  @Test
  public void LaunchApplication() {
	  System.out.println("Application Launched passed.");
  }
  
  @Test
  public void VerifyTitle() {
	  System.out.println("VerifyTitle passed.");
  }
  
  @Test
  public void VerifyLogo() {
	  System.out.println("VerifyLogo passed.");
  }
}
