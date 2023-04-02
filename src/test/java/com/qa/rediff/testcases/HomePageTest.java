package com.qa.rediff.testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.rediff.base.TestBase_Rediff;

public class HomePageTest extends TestBase_Rediff {
	public HomePageTest() throws Exception {
		super();
	
	}
	public static WebDriver driver;
	public static ChromeOptions options;
	public static SoftAssert softassert = new SoftAssert();
	
	@BeforeMethod
	public void setUp() throws Exception {
		driver = initializeBrowser(prop.getProperty("browserName"));
		driver.findElement(By.linkText("Sign in")).click();
		driver.findElement(By.cssSelector("input#login1")).sendKeys(prop.getProperty("validEmail"));
		driver.findElement(By.cssSelector("input#password")).sendKeys(prop.getProperty("validPassword"));
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("input.signinbtn")).click();
		WebElement logOutButton = driver.findElement(By.cssSelector("a.rd_logout"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(logOutButton)).click();
	}
	@Test
	public void presenceofRediffLogo() {
		driver.findElement(By.cssSelector("div.header div a+span a+a b")).click();
		WebElement rediffLogo = driver.findElement(By.cssSelector("span.hmsprite.logo"));
		softassert.assertTrue(rediffLogo.isDisplayed());
		softassert.assertAll();
	
	}
	

}
