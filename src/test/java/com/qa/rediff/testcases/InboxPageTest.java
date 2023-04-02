package com.qa.rediff.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.rediff.base.TestBase_Rediff;

public class InboxPageTest extends TestBase_Rediff {
	public InboxPageTest() throws Exception {
		super();
		
	}
	public static WebDriver driver;
	public static ChromeOptions options;
	public static SoftAssert softassert = new SoftAssert();

	
	@BeforeMethod
	public void launchurl() {
		driver = initializeBrowser(prop.getProperty("browserName"));
		
	}
	@Test(priority=1)
	public void clickOnSignInLink() {
		driver.findElement(By.linkText("Sign in")).click();
		WebElement rediffmaillogo = driver.findElement(By.cssSelector("div.logtext"));
		softassert.assertTrue(rediffmaillogo.isDisplayed());
		softassert.assertAll();
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	
		
	}
	
		

}

