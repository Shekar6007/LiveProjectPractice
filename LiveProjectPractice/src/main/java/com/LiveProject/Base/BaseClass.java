package com.LiveProject.Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.LiveProject.Actions.ActionDivers;
import com.LiveProject.utility.ExtentManager;


public class BaseClass {
	
	 public static Properties prop;
	 public static WebDriver driver;
	 
	 //for parallel testing,we use below type to intialize browsers
	/* public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();
	 
	 public static WebDriver getdriver(){
		 return driver.get();
	 }*/

	 @BeforeSuite(groups={"smoke","sanity","Regression"})
	 public void loadConfig(){
		 DOMConfigurator.configure("log4j.xml");
		 
		 ExtentManager.setExtent();
		 
		 try {
				prop = new Properties();
				System.out.println("super constructer invoked");
				FileInputStream ip = new FileInputStream(
						System.getProperty("user.dir") + "\\Configuration\\config.prorperties");
				prop.load(ip);
				System.out.println("driver: "+driver);
				

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
	 }
	 
   
		
	
	

   
public static void launchApp(String browserName) throws InterruptedException{
		
		//String browserName=prop.getProperty("browser");
		
		if(browserName.contains("chrome")){
			System.setProperty("webdriver.chrome.driver", "./drivers//chromedriver.exe");
			driver=new ChromeDriver();
			//WebDriverManage.chromedriver.setup();
			//driver.set(new ChromeDriver());
			
		}else if(browserName.contains("FireFox")){
			System.setProperty("webdriver.gecko.driver", "./drivers//geckodriver.exe");
			driver=new FirefoxDriver();
			}else if(browserName.contains("Edge")){
				System.setProperty("webdriver.edge.driver", "./drivers//msedgedriver.exe");
				driver = new EdgeDriver();
				
			}
	ActionDivers actn=new ActionDivers();
	actn.implicitWait(driver, 10);
	actn.pageLoadTimeOut(driver, 30);
	
	actn.launchUrl(driver, prop.getProperty("url"));
	actn.implicitWait(driver, 10);
	}

@AfterSuite
public void afterSuite(){
	ExtentManager.endReport();
}
	
}
