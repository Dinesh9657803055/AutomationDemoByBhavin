package com.admin;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import Utility.Util;
import WebPages.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	public static WebDriver driver;
	
	public LoginPage loginPage;
	public ProductPage productPage;
	public OrderPage orderPage;
	public LineItemsPage lineItemsPage;
	
	public static WebDriverWait wait;
	public String randomProductString = Util.randomProductString();
	public String randomOrderString = Util.randomOrderString();
	
	public static String Prod;
	public static String Ord;
	
	@BeforeSuite
	public void assignvalue() {
		Prod = randomProductString;
		Ord = randomOrderString;
	}
	
	@BeforeTest
	public void setup() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		wait = new WebDriverWait(driver, Duration.ofMinutes(1)); 	
		
		driver.get("https://motor-admin-production-4dbc.up.railway.app");
		
	
	}
	@BeforeClass
	public void beforeClass(){
		loginPage = new LoginPage(driver);
		productPage =  new ProductPage(driver);
		orderPage =  new OrderPage(driver);
		lineItemsPage = new LineItemsPage(driver);
	}
	@AfterSuite
	public void closeBrowser() {
		System.out.println("\n**Browser Closed");
		driver.quit();
	}

}
