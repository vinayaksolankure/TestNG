package TestNG.TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataProviders {

	@Test(dataProvider = "searchDataSet", dataProviderClass = DataProviders_Class.class)  
	public void DataProviders_Googlesearch(String country, String monument) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver  = new ChromeDriver();
		driver.get("https://www.google.com/");

		WebElement searchbox = driver.findElement(By.name("q"));
		//enter key combination of country and monument
		searchbox.sendKeys(country + " " + monument);
		Thread.sleep(2000);

		WebElement searchbutton = driver.findElement(By.name("btnK"));
		searchbutton.click();
	}
}
