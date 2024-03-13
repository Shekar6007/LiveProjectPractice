package com.LiveProject.testcases;

import java.util.HashMap;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.LiveProject.Actions.ActionDivers;
import com.LiveProject.Base.BaseClass;
import com.LiveProject.Dataprovidrs.DataProvidrsCls;
import com.LiveProject.Pageobjects.AccountCreatnPage;
import com.LiveProject.Pageobjects.IndexPage;
import com.LiveProject.Pageobjects.LoggedInPage;
import com.LiveProject.Pageobjects.SignUpPage;

public class AccountCreatnPage1Test extends BaseClass {
	
	
	IndexPage indexpage ;
	SignUpPage uppage;
	LoggedInPage loginpage;
	AccountCreatnPage creatnpage;
	
	
	
	@Parameters("browser")
    @BeforeMethod(groups={"smoke","sanity","Regression"})
	public void setup(String browser) throws InterruptedException{
		
		launchApp(browser);
	}
	
	
	@AfterMethod(groups={"smoke","sanity","Regression"})
	public void teardown(){
		driver.quit();
	}
	
	@Test(groups="Regression",dataProvider="createAccntDetails", dataProviderClass=DataProvidrsCls.class)
	public void createAccount(HashMap<String,String> hashmapvalue) throws InterruptedException{
		indexpage= new IndexPage();
		uppage=indexpage.clickOnSignIn();
		creatnpage=uppage.signUpFunction(hashmapvalue.get("Name"), hashmapvalue.get("Email"));
		creatnpage.createAccntn(hashmapvalue.get("Gender"),
				hashmapvalue.get("Namee"),
		        hashmapvalue.get("Password"),
		        hashmapvalue.get("Day"),
		        hashmapvalue.get("Month"),
		        hashmapvalue.get("Year"),
				hashmapvalue.get("Firstname"),
				hashmapvalue.get("LastName"),
				hashmapvalue.get("Address"),
				hashmapvalue.get("Country"),
				hashmapvalue.get("State"),
				hashmapvalue.get("City"),
				hashmapvalue.get("Zipcode"),
				hashmapvalue.get("Number"));
		
		
}}
