package TestNG.TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import io.github.bonigarcia.wdm.WebDriverManager;


public class AssertionDemo {
	WebDriver driver;
	@Test
	public void testMethod() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		SoftAssert softVerify = new SoftAssert();
		
		driver.get("https://testautomationpractice.blogspot.com/");
		Thread.sleep(5000);
		
		System.out.println("Verifying Title....");
		String expectedTitle = "Automation Testing Practice 1";
		String actualTitle = driver.getTitle();
		softVerify.assertEquals(expectedTitle, actualTitle);
		
		System.out.println("Verifying presence of Wikipedia-icon....");
		WebElement icon = driver.findElement(By.className("wikipedia-icon"));
		softVerify.assertTrue(icon.isDisplayed());
		
		System.out.println("Verifying presence of Search-button....");
		WebElement searchButton = driver.findElement(By.className("wikipedia-search-button"));
		softVerify.assertTrue(searchButton.isDisplayed());
		driver.quit();
		
		//report all failure messages
		softVerify.assertAll();
	}
}
