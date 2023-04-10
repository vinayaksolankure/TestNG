package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//Using Page Factory
public class LoginPage2 {
	WebDriver driver;

	// Constructor
	LoginPage2(WebDriver d)
	{
		driver = d;
		// this method will create WebElemets
		PageFactory.initElements(driver, this);
	}

	// Identify WebElements
	// Identify user name
	@FindBy(id = "user-name")
	WebElement username;

	// Identify password
	@FindBy(id = "password")
	WebElement password;

	// Identify password
	@FindBy(id = "login-button")
	WebElement loginButton;

	// Methods of operation to be performed on WebElements 
	public void enterUsername(String uname)
	{
		username.sendKeys(uname);
	}

	public void enterPassword(String pass)
	{
		password.sendKeys(pass);
	}

	public void ClickOnLoginButton()
	{
		loginButton.click();
	}
}
