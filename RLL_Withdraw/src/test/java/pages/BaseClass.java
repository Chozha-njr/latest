package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class BaseClass {

public static WebDriver driver = null;
	
	public static WebDriver getDriver()
	{
		return driver;
	}

	@Before
	public static void getBrowser()
	{
	    driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("http://dbankdemo.com/bank/login");	
	}
	
	@After
	public static void teardown()
	{
		driver.close();
	}
	
	
}

