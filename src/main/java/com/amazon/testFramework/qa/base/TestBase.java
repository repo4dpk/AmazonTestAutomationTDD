package com.amazon.testFramework.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.amazon.testFramework.qa.util.util;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase(){
		try {
			prop = new Properties();
			System.out.println("Accessing the configuration");
			FileInputStream ip = new FileInputStream("D:\\Eclipse_Oxy\\testFramework\\src\\main\\java\\com\\amazon"
					+"\\testFramework\\qa\\config\\config.properties");
			System.out.println("Success Path");
			prop.load(ip);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void intitialization() {
		
		String browserName = prop.getProperty("browser");
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dlab_Voice\\Downloads\\chromedriver.exe");
			driver = new ChromeDriver();
		} 
		else if(browserName.equals("FF")){
			System.out.println("Entered to FF");
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\Dlab_Voice\\Downloads\\geckodriver-v0.20.1-win64\\geckodriver.exe");	
			System.out.println("Picked the Driver");
			driver = new FirefoxDriver(); 
			System.out.println("FF instnce created");
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(util.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(util.IMPLICIT_WAIT,TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		
	}
}
