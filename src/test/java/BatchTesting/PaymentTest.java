package BatchTesting;

import org.testng.annotations.Test;

public class PaymentTest {
  @Test
  public void CashOnDelivery() {
	  System.out.println("CashOnDelivery passed.");
  }
  
  @Test
  public void NetBanking() {
	  System.out.println("NetBanking passed.");
  }
}
