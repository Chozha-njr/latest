package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;

public class TestBase {
	public static WebDriver driver;
	@BeforeClass
	public static void getBrowser()
	{
	    driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("http://dbankdemo.com/bank/login");	
	}
}
