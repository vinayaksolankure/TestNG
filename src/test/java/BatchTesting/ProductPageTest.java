package BatchTesting;

import org.testng.annotations.Test;

public class ProductPageTest {
  @Test
  public void AddProductToWishlist() {
	  System.out.println("AddProductToWishlist passed.");
  }
  
  @Test
  public void AddProductToCart() {
	  System.out.println("AddProductToCart passed.");
  }
  
  @Test
  public void SelectQuantity() {
	  System.out.println("SelectQuantity passed.");
  }
}
