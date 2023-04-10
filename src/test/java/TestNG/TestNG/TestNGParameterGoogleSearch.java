package TestNG.TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNGParameterGoogleSearch {
	@Parameters({"keyword"})
	@Test
	public void googleSearch(String searchdata) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		
		WebElement searchbox = driver.findElement(By.name("q"));
		searchbox.sendKeys(searchdata);
		
		Assert.assertEquals(searchdata, searchbox.getAttribute("value"));
		driver.quit();
	}

}
