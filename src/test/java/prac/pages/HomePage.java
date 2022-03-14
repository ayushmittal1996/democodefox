package prac.pages;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements( driver, this);
	}

	@FindBy(xpath = ".//a[contains(text(), 'Home')]")
	public WebElement linkHome;
	
	@FindBy(xpath = ".//a[contains(text(), 'XYZ')]")
	public WebElement linkXYZ;

	public boolean isLogHavingError(WebElement link, WebDriver driver) {

		boolean isError = false;

		//link.click();
		driver.get("https://www.foxweather.com/XYZ");
		LogEntries foundLogs = driver.manage().logs().get(LogType.BROWSER);
		for (LogEntry log : foundLogs) {
			String message = log.getMessage();
			System.out.println(message);
			if(message.contains("status of 404")) {
			System.out.println("Wait here");
			}
			if (message.startsWith("https://")
					&& (message.charAt(message.length() - 6) == '4' || message.charAt(message.length() - 6) == '5')) {
				assertTrue(false, "Fail : Following URL is bad url : ");
			}
		}
		return isError;
	}

}
