package TestNGReportsDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNGReportClassExample {
	
	@Test
	public void googleSearch() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions(); 
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		Reporter.log("Chrome Browser launched.........");
		driver.manage().window().maximize();
		
		driver.get("https://www.google.com/");
		Reporter.log("Google URL opened...........");
		
		WebElement searchBox = driver.findElement(By.name("q"));
		
		searchBox.sendKeys("India Gate");
		Reporter.log("Entered required Value...........");
		
		searchBox.sendKeys(Keys.ENTER);
		Reporter.log("Pressed on enter key............");
		
		Reporter.log("Closing browser................");
		driver.quit();
	}
}
