package com.LiveProject.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.LiveProject.Base.BaseClass;
import com.LiveProject.Pageobjects.IndexPage;
import com.LiveProject.Pageobjects.LoggedInPage;
import com.LiveProject.Pageobjects.SearchPage;
import com.LiveProject.Pageobjects.SearchResultPage;
import com.LiveProject.Pageobjects.SignUpPage;

public class SearchPage1Test extends BaseClass {
	
	IndexPage indexpage;
	SignUpPage uppage;
	LoggedInPage loginpage;
	SearchPage searchpage;
	SearchResultPage resultpage;

	 @Parameters("browser")
	@BeforeMethod(groups={"smoke","sanity","Regression"})
	public void setup(String browser) throws InterruptedException{
		
		launchApp(browser);
	}
	
	@AfterMethod(groups={"smoke","sanity","Regression"})
	public void teardown(){
		driver.quit();
	}
	
	@Test(groups={"smoke","sanity"})
	public void searchProduct() throws InterruptedException{
		indexpage=new IndexPage();
		uppage=indexpage.clickOnSignIn();
		loginpage=uppage.loginFunction(prop.getProperty("username"), prop.getProperty("password"));
		searchpage=loginpage.clickOnProducts();
		resultpage=searchpage.searchBoxFunction("t-shirt");
		
	}

}
