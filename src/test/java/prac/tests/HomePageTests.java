package prac.tests;

import java.util.logging.Level;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.testng.annotations.Test;

import prac.pages.HomePage;

public class HomePageTests {
	
	@Test
	public void testHome() {
		
		System.setProperty("webdriver.chrome.driver", "D:\\eclipse\\prac\\src\\test\\resources\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
        LoggingPreferences logPrefs = new LoggingPreferences();
        logPrefs.enable(LogType.BROWSER, Level.ALL);
        options.setCapability("goog:loggingPrefs", logPrefs);
		WebDriver driver = new ChromeDriver(options);
		
		driver.get("https://www.foxweather.com/");
		
		HomePage homePage = new HomePage(driver);
		//String homeURL = homePage.linkHome.getAttribute("href");

		//homePage.isLogHavingError(homePage.linkHome, driver);
		
		homePage.isLogHavingError(homePage.linkXYZ, driver);
		
		driver.close();
		
	}

}
