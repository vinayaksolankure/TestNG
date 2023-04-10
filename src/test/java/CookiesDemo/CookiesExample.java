package CookiesDemo;

import java.util.Set;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CookiesExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions(); 
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");

		// Capture all cookies
		Set<Cookie> cookiesList = driver.manage().getCookies();
		System.out.println("Before adding size: " + cookiesList.size());

		for(Cookie ck:cookiesList)
		{
			System.out.println("Name and Value of the cookie: " + ck.getName() + "=" + ck.getValue());
		}

		System.out.println("#######################################################################");

		// Get specific cookie according to name
		Cookie cookieName = driver.manage().getCookieNamed("i18n-prefs");
		System.out.println("Name of the cookie: " + cookieName);

		// create cookie
		Cookie cookieobj = new Cookie("TestCookie", "www.amazon.in");

		// add cookie to browser
		driver.manage().addCookie(cookieobj);

		// print size and number of cookies 
		Set<Cookie> cookiesList2 = driver.manage().getCookies();
		System.out.println("After adding size: " + cookiesList2.size());

		for(Cookie ck2:cookiesList2)
		{
			System.out.println("Name and Value of the cookie: " + ck2.getName() + "=" + ck2.getValue());
		}

		System.out.println("#######################################################################");

		// delete cookie
		//driver.manage().deleteCookie(cookieobj);
		// delete cookie by name
		driver.manage().deleteCookieNamed("TestCookie");

		Set<Cookie> cookiesList3 = driver.manage().getCookies();
		System.out.println("Size after deleting one cookie: " + cookiesList3.size());

		for(Cookie ck3:cookiesList3)
		{
			System.out.println("Name and Value of the cookie: " + ck3.getName() + "=" + ck3.getValue());
		}

		System.out.println("#######################################################################");

		//delete all cookies
		driver.manage().deleteAllCookies();

		Set<Cookie> cookiesList4 = driver.manage().getCookies();
		System.out.println("Size after deleting all cookie: " + cookiesList4.size());

		driver.quit();
	}

}
