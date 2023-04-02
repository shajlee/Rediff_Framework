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

public class LandingPageTest extends TestBase_Rediff {
	public LandingPageTest() throws Exception {
		super();
		
	}

	public static WebDriver driver;
	public static ChromeOptions options;
	public static SoftAssert softassert = new SoftAssert();

	@BeforeMethod
	public void launchurl() {
		driver = initializeBrowser(prop.getProperty("browserName"));
		
	}

	@Test(priority = 1)
	public void validateCurrentUrlActualTitle() {
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());

		String actualCurrentUrl   =  prop.getProperty("actualCurrentUrl");
		String expectedCurrentUrl =  driver.getCurrentUrl();

		String actualTitle =   prop.getProperty("actualTitle");
		String expectedTitle = driver.getTitle();

		if (actualCurrentUrl.equals(expectedCurrentUrl) && actualTitle.equals(expectedTitle)) {
			System.out.println("Url is Valid and Functional");
		} else {
			System.out.println("Url is not valid");
		}

	}

	@Test(priority = 2)
	public void rediffLogoPresence() {
		WebElement redifflogo = driver.findElement(By.cssSelector("span.hmsprite.logo"));
		softassert.assertTrue(redifflogo.isDisplayed());
		System.out.println(redifflogo.isDisplayed());
		softassert.assertAll();
	}

	@Test(priority = 3)
	public void SignInLinkPresence() {
		WebElement signinlink = driver.findElement(By.linkText("Sign in"));
		softassert.assertTrue(signinlink.isDisplayed() && signinlink.isEnabled());
		System.out.println(signinlink.isDisplayed() && signinlink.isEnabled());
		softassert.assertAll();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();

	}

}
