package BatchTesting;

import org.testng.annotations.Test;

public class LoginTest {
  @Test
  public void LoginByMoblieNumber() {
	  System.out.println("Logged In by Mobile Number Passed.");
  }
  
  @Test
  public void LoginByMail() {
	  System.out.println("Logged In by Mail Passed.");
  }
}
