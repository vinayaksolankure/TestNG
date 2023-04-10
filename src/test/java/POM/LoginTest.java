package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver  = new ChromeDriver();
		
		LoginPage2 LoginPage = new LoginPage2(driver);
		
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		
		
		LoginPage.enterUsername("standard_user");
		LoginPage.enterPassword("secret_sauce");
		LoginPage.ClickOnLoginButton();
		

	}

}
