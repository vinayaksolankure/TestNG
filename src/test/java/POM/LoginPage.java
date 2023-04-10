package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

// Without Page Factory
public class LoginPage {
	
	WebDriver driver;
	
	// Constructor
	LoginPage(WebDriver d)
	{
		driver = d;
	}

	// Locating(Identifying) WebElements
	By username = By.id("user-name");
	By password = By.id("password");
	By loginButton = By.id("login-button");
	
	// Methods of operation to be performed on WebElements 
	public void enterUsername(String uname)
	{
		driver.findElement(username).sendKeys(uname);
	}
	
	public void enterPassword(String pass)
	{
		driver.findElement(password).sendKeys(pass);
	}
	
	public void ClickOnLoginButton()
	{
		driver.findElement(loginButton).click();
	}
}
