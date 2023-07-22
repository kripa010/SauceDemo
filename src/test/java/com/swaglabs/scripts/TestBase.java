package com.swaglabs.scripts;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;

//import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	WebDriver driver;
	public static Properties prop=null;
	
	String driverPath= System.getProperty("user.dir")+File.separator+"drivers"+File.separator+"chromedriver.exe";
	
	public static void TestBase() {
		
		try {
        	prop = new Properties();
            FileInputStream ip = new FileInputStream("D:\\eclipse workspace\\Saucedemo\\src\\test\\resources\\config.properties");
          
            prop.load(ip);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
		  
    }
	
	
	@BeforeTest
 
	public void onSetup() {
		TestBase();
		String browserName=prop.getProperty("browser");
		
		if(browserName.equals("chrome")) {
			
			System.setProperty("webdriver.chrome.driver",driverPath);
			driver = new ChromeDriver();
			System.out.println("Chrome browser opening...");
		}
		else if(browserName.equals("firefox")) {
			
			System.setProperty("webdriver.gecko.driver",driverPath);
			driver = new FirefoxDriver();
			System.out.println("Firefox browser opening...");
		}
				
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize(); 
		
	}
}


