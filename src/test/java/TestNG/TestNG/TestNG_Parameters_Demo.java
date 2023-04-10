package TestNG.TestNG;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNG_Parameters_Demo {
  @Test
  @Parameters({"i","j"})
  public void add(int a, int b) {
	  System.out.println("additon: " + (a+b));
  }
  
  @Test
  @Parameters({"i","j"})
  public void substraction(int a, int b) {
	  System.out.println("subsraction: " + (a-b));
  }
  
  @Test
  @Parameters({"i","j"})
  public void multiplication(int a, int b) {
	  System.out.println("multiplication: " + (a*b));
  }
  
  @Test
  @Parameters({"i","j"})
  public void division(int a, int b) {
	  System.out.println("division: " + (a/b));
  }
}
