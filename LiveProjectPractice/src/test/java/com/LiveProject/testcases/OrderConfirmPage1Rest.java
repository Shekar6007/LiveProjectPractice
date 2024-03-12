package com.LiveProject.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.LiveProject.Base.BaseClass;
import com.LiveProject.Pageobjects.AddToCartPage;
import com.LiveProject.Pageobjects.AddressPage;
import com.LiveProject.Pageobjects.IndexPage;
import com.LiveProject.Pageobjects.LoggedInPage;
import com.LiveProject.Pageobjects.OrderConfirmPage;
import com.LiveProject.Pageobjects.OrderOrProceedPAge;
import com.LiveProject.Pageobjects.PaymentPage;
import com.LiveProject.Pageobjects.SearchPage;
import com.LiveProject.Pageobjects.SearchResultPage;
import com.LiveProject.Pageobjects.SignUpPage;

public class OrderConfirmPage1Rest extends BaseClass {
	
	IndexPage indexpage;
	SignUpPage uppage;
	LoggedInPage loginpage;
	SearchPage searchpage;
	SearchResultPage resultpage;
	AddToCartPage addtocart;
	OrderOrProceedPAge orderproceedpage;
    AddressPage addresspage;
    PaymentPage paypage;
    OrderConfirmPage confirmpage;
    
    @Parameters("browser")
    @BeforeMethod(groups={"smoke","sanity","Regression"})
	public void setup(String browser) throws InterruptedException{
		
		launchApp(browser);
	}
	
	@AfterMethod(groups={"smoke","sanity","Regression"})
	public void teardown(){
		driver.quit();
	}
	
	@Test(groups="Regression")
	public void clickonPay() throws InterruptedException{
		indexpage=new IndexPage();
		uppage=indexpage.clickOnSignIn();
		loginpage=uppage.loginFunction(prop.getProperty("username"), prop.getProperty("password"));
		searchpage=loginpage.clickOnProducts();
		resultpage=searchpage.searchBoxFunction("t-shirt");
		resultpage.isProductAvailable();
		addtocart=resultpage.clickOnviewProduct();
		orderproceedpage=addtocart.addItemsToCart("2");
		addresspage= orderproceedpage.clickOnProceedToCheck();
		paypage=addresspage.clickOnPlaceOrder();
		confirmpage=paypage.enterCardDetails("dbi", "653536733653", "463", "04", "2029");
		loginpage=confirmpage.clickOnContinue();
	}


}
