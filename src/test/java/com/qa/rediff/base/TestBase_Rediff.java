package com.qa.rediff.base;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import com.qa.rediff.utilities.Utilities_Rediff;

public class TestBase_Rediff {
	public static WebDriver driver;
	public static ChromeOptions options;
	public static FirefoxOptions options1;
	public static EdgeOptions options2;
	public static Properties prop;
	
	public void loadPropertiesFile() throws Exception {
		prop = new Properties();
		FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\com\\qa\\rediff\\propertiesfiles\\configRediff.Properties");
		prop.load(ip);
	}
	public TestBase_Rediff() throws Exception {
		prop = new Properties();
		FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\com\\qa\\rediff\\propertiesfiles\\configRediff.Properties");
		prop.load(ip);
	}
	public WebDriver initializeBrowser(String BrowserName) {
		if(BrowserName.equalsIgnoreCase("chrome")) {
			options = new ChromeOptions();
			options.setPageLoadStrategy(PageLoadStrategy.EAGER);
			options.addArguments("--start-maximized");
			options.addArguments("--incognito");
			driver = new ChromeDriver(options);
		}else if(BrowserName.equalsIgnoreCase("firefox")) {
			options1 = new FirefoxOptions();
			options1.addArguments("-private");
			driver = new FirefoxDriver(options1);
		}else if(BrowserName.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}
		driver.get(prop.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utilities_Rediff.IMPLICIT_WAIT_TIME));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Utilities_Rediff.PAGELOAD_TIME));
		return driver;
		
		
			
		}
	}
		
	
	
	
	


