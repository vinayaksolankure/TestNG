package TestNG.TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.SkipException;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class ListenersDemo {
	@Test
	public void login() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		Thread.sleep(1000);

		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		
		Assert.assertEquals(driver.getTitle(), "Swag Labs");
		driver.quit();
	}
	
	@Test
	public void testFail() {
		System.out.println("Failed TestCase.");
		Assert.assertTrue(false);
	}
	
	@Test
	public void testSkip() {
		System.out.println("Skipped TestCase.");
		throw new SkipException("Skip Exception thrown.......");
	}
}
