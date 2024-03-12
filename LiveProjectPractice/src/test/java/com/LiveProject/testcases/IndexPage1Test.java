package com.LiveProject.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.LiveProject.Base.BaseClass;
import com.LiveProject.Pageobjects.IndexPage;
import com.LiveProject.Pageobjects.SignUpPage;
import com.LiveProject.utility.Log;

public class IndexPage1Test extends BaseClass{
	
	IndexPage indexpage;
	SignUpPage uppage;
	
	 @Parameters("browser")
	@BeforeMethod(groups={"smoke","sanity","Regression"})
	public void setup(String browser) throws InterruptedException{
	    Log.info("Browser is going to open with url");
		launchApp(browser);
		Thread.sleep(4000);
		
		}
	
	@AfterMethod(groups={"smoke","sanity","Regression"})
	public void teardown(){
		Log.info("browser is going to close");
		driver.quit();
	}
	
	@Test(groups="smoke")
	public void verifyLogo(){
		Log.startTestCase("verifyLogo");
		indexpage = new IndexPage();
		Log.info("index page logo validation starts");
	boolean result =	indexpage.validateLogo();
	Assert.assertTrue(result);
	Log.info("Logo is verified successfully");
	Log.endTestCase("verifyLogo");
	}
	
	@Test(groups="sanity")
	public void titleee(){
		Log.startTestCase("titleee");

		String myTitle= indexpage.getMyTitle();
		Log.info("verifying act tile with expected title");
		Assert.assertEquals(myTitle, "AutomationExercise");
		Log.info("title verification success");
		Log.endTestCase("titleee");
	}
	
	@Test(groups={"sanity","Regression"})
	public void clicksignup() throws InterruptedException{
		Log.startTestCase("clicksignUp");

		indexpage=new IndexPage();
		Log.info("clicking on signin button");
		uppage=indexpage.clickOnSignIn();
		Log.info("clicked on sign in button");
		Log.endTestCase("clicksignup");
		
	}

}
