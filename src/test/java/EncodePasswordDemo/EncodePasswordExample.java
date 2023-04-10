package EncodePasswordDemo;

import org.apache.commons.codec.binary.Base64;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EncodePasswordExample {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions(); 
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
		//Thread.sleep(5000);
		
		// encode password
		String password = "secret_sauce";
		
		byte[] encodedPassword = Base64.encodeBase64(password.getBytes());
		
		System.out.println(new String(encodedPassword));
		
		//enter username
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		
		// decode password
		byte[] decodedPassword =  Base64.decodeBase64("c2VjcmV0X3NhdWNl");
		
		driver.findElement(By.id("password")).sendKeys(new String(decodedPassword));
		driver.findElement(By.id("login-button")).click();
		
		//driver.quit();
	}

}
