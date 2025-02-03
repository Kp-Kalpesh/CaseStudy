package org.caseStudy_FIS;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.utilities.BaseUtility;

public class verifyCart {
	private static WebDriver driver;
	private WebDriver wt;

	public static void main(String[] args) {

		String bName = "Ch";
		String Url = "https://ebay.com";
		BaseUtility bu = new BaseUtility();
		driver = bu.launchBrowser(Url, bName);
		

		// enter the valid data
		WebElement searchInputField = driver.findElement(By.xpath("//input[@placeholder='Search for anything']"));
		searchInputField.sendKeys("book");

		//Click on the search button
		WebElement searchBtn = driver.findElement(By.xpath("//button[@type='submit']"));
		searchBtn.click();

		//Click on the First Record Title		
		WebElement clickOnFirstRecord = driver.findElement(By.xpath("(//li//div/a[@class='s-item__link'])[3]"));
		clickOnFirstRecord.click();


		//		Handle to Next Window
		windowHandle();

		//		Click on Add to Cart Button
		driver.findElement(By.xpath("(//a[@rel='nofollow'])[4]")).click();

		//Click on the Cart icon
		driver.findElement(By.xpath("(//a[@class='gh-flyout__target'])[3]")).click();

		//	verify The book has successfully added into the cart
		verifyCart obj = new verifyCart();

		if(obj.WebDriverWt()) {
			System.out.println("The Product successfully added into the Cart");			
		}else{
			System.out.println("The Product did not add into the Cart");
		};
				driver.quit();
	}




	public static boolean windowHandle() {
		String parentId2 = driver.getWindowHandle();		

		Set<String> allWinIds = driver.getWindowHandles();
		Iterator<String> itr = allWinIds.iterator();
		String id1 = itr.next();

		String parentId1 = driver.getWindowHandle();		
		if(id1.equals(parentId1))
		{
			id1 = itr.next();
		}

		driver.switchTo().window(id1);
		return false;
	}

	public boolean WebDriverWt() {
		WebElement ele = driver.findElement(By.xpath("//a[@rel='noreferrer']"));

		WebDriverWait wt = new WebDriverWait(driver, Duration.ofSeconds(10));
		wt.until(ExpectedConditions.visibilityOf(ele));
		return true;
	}
}
