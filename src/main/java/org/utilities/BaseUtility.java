package org.utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseUtility {

	private WebDriver driver;                            //default value = null
	public void launchBrowser()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://ebay.com");
		driver.manage().deleteAllCookies();
		
	}


	public void waitForVisibilityOFElement(WebDriver driver, int time, WebElement ele)
	{
		WebDriverWait wt = new WebDriverWait(driver, Duration.ofSeconds(time));
		wt.until(ExpectedConditions.visibilityOf(ele));

	}

}
