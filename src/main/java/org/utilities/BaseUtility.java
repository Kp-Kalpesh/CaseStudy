package org.utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseUtility {

	private WebDriver driver;                            //default value = null
	public WebDriver launchBrowser(String Url, String bName)
	{
		if(bName.equalsIgnoreCase("CH") || bName.equalsIgnoreCase("Chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}else if(bName.equalsIgnoreCase("FF") || bName.equalsIgnoreCase("FireFox"))
		{
			FirefoxOptions options = new FirefoxOptions();
			driver = new FirefoxDriver(options);
		}else if(bName.equalsIgnoreCase("ED") || bName.equalsIgnoreCase("Edge"))
		{
			EdgeOptions options = new EdgeOptions();
			WebDriver driver = new EdgeDriver(options);
		}else {
			System.out.println("Invalid browser Name!");
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(Url);
		driver.manage().deleteAllCookies();

		return driver;

	}


	public void waitForVisibilityOFElement(WebDriver driver, int time, WebElement ele)
	{
		WebDriverWait wt = new WebDriverWait(driver, Duration.ofSeconds(time));
		wt.until(ExpectedConditions.visibilityOf(ele));

	}

}
