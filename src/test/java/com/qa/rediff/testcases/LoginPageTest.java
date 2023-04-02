package com.qa.rediff.testcases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.rediff.base.TestBase_Rediff;
import com.qa.rediff.utilities.Utilities_Rediff;

public class LoginPageTest extends TestBase_Rediff {
	public LoginPageTest() throws Exception {
		super();
		
	}
	public static WebDriver driver;
	public static ChromeOptions options;
	public static SoftAssert softassert = new SoftAssert();
	
	@BeforeMethod
	public void setUp() {
		driver = initializeBrowser(prop.getProperty("browserName"));
		driver.findElement(By.linkText("Sign in")).click();
	}
	@Test(priority=1, dataProvider="supplyData")
	public void logInWithValidCredentials(String email, String password) {
		driver.findElement(By.cssSelector("input#login1")).sendKeys(prop.getProperty("validEmail"));
		driver.findElement(By.cssSelector("input#password")).sendKeys(prop.getProperty("validPassword"));
		driver.findElement(By.cssSelector("input.signinbtn")).click();
		WebElement inbox = driver.findElement(By.cssSelector("a.rd_active"));
		softassert.assertTrue(inbox.isDisplayed() && inbox.isEnabled());
		softassert.assertAll();
		
	}
	@DataProvider
	public Object supplyData() {
		Object[][] data = {{prop.getProperty("DataProviderEmail1"), prop.getProperty("DataProviderPassword1")},
				           {prop.getProperty("DataProviderEmail2"), prop.getProperty("DataProviderPassword2")},
				           {prop.getProperty("DataProviderEmail3"), prop.getProperty("DataProviderPassword3")}};
		return data;
		
	}
	
	@Test(priority=2)
	public void logInWithInvalidCredentials() {
		driver.findElement(By.cssSelector("input#login1")).sendKeys(Utilities_Rediff.generateDateTimeStampEmail());
		driver.findElement(By.cssSelector("input#password")).sendKeys(Utilities_Rediff.generateDateTimeStampPassword());
		driver.findElement(By.cssSelector("input.signinbtn")).click();
		String actualWarningMessage = driver.findElement(By.cssSelector("div#div_login_error b")).getText();
	    softassert.assertTrue(true, actualWarningMessage);
	    softassert.assertAll();
	}
	@Test(priority=3)
	public void logInWithValidEmailInvalidPassword() {
		driver.findElement(By.cssSelector("input#login1")).sendKeys(prop.getProperty("validEmail"));
		driver.findElement(By.cssSelector("input#password")).sendKeys(Utilities_Rediff.generateDateTimeStampPassword());
		driver.findElement(By.cssSelector("input.signinbtn")).click();
		String actualWarningMessage = driver.findElement(By.cssSelector("div#div_login_error b")).getText();
	    softassert.assertTrue(true, actualWarningMessage);
	    softassert.assertAll();
		
	
	}
	@Test(priority=4)
	public void logInWithInvalidEmailValidPassword() {
		driver.findElement(By.cssSelector("input#login1")).sendKeys(Utilities_Rediff.generateDateTimeStampEmail());
		driver.findElement(By.cssSelector("input#password")).sendKeys(prop.getProperty("validPassword"));
		driver.findElement(By.cssSelector("input.signinbtn")).click();
		String actualWarningMessage = driver.findElement(By.cssSelector("div#div_login_error b")).getText();
	    softassert.assertTrue(true, actualWarningMessage);
	    softassert.assertAll();
	
	}
	@Test(priority=5)
	public void logInWithNoCredentials() {
		driver.findElement(By.cssSelector("input.signinbtn")).click();
		Alert alert = driver.switchTo().alert();
		String actualAlertText = alert.getText();
		softassert.assertTrue(true, actualAlertText);
		softassert.assertAll();
	
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
