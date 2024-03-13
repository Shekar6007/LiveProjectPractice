package com.LiveProject.Pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.LiveProject.Actions.ActionDivers;
import com.LiveProject.Base.BaseClass;

public class AccountCreatnPage extends BaseClass {
	
	ActionDivers actn = new ActionDivers();


	@FindBy(xpath="//*[@id='form']/div/div/div/div[1]/h2/b")
	WebElement enterAccntInfrmatn;
	
	@FindBy(id="id_gender1")
	WebElement mr;
	
	@FindBy(id="id_gender2")
	WebElement mrs;
	
	@FindBy(id="name")
	WebElement namee;
	
	@FindBy(id="password")
	WebElement pwd;
	
	@FindBy(id="days")
	WebElement day;
	
	@FindBy(id="months")
	WebElement month;
	
	@FindBy(id="years")
	WebElement year;
	
	@FindBy(id="optin")
	WebElement checkbox;
	
	@FindBy(id="first_name")
	WebElement fname;
	
	@FindBy(id="last_name")
	WebElement lname;
	
	@FindBy(id="address1")
	WebElement adress;
	
	@FindBy(id="country")
	WebElement countryy;
	
	@FindBy(id="state")
	WebElement statee;
	
	@FindBy(id="city")
	WebElement cityy;
	
	@FindBy(id="zipcode")
	WebElement zip;
	
	@FindBy(id="mobile_number")
	WebElement num;
	
	@FindBy(xpath="//*[@id='form']/div/div/div/div[1]/form/button")
	WebElement createbtn;
	
	@FindBy(xpath = "//*[@id='form']/div/div/div/div/a")
	private WebElement continu;
	
	public AccountCreatnPage(){
		PageFactory.initElements(driver, this);
	}
	
	public LoggedInPage createAccntn(String gender,String name,
			String passwrd,String days,String months,String years,String fnamee,
			String lnamee,String adrress,String countri,String statte,String citty,
			String zipcod,String mNum) throws InterruptedException{
		


		if(gender.equalsIgnoreCase("mr")){
			ActionDivers.click(driver, mr);
		}else{
			ActionDivers.click(driver, mrs);
		}
		
		ActionDivers.type(namee, name);
		ActionDivers.type(pwd, passwrd);
		actn.selectByValue(day, days);
		actn.selectByValue(month, months);
		actn.selectByValue(year, years);
		ActionDivers.click(driver, checkbox);
		ActionDivers.type(fname, fnamee);
		ActionDivers.type(lname, lnamee);
		ActionDivers.type(adress, adrress);
		actn.selectByValue(countryy, countri);
		ActionDivers.type(statee, statte);
		ActionDivers.type(cityy, citty);
		ActionDivers.type(zip, zipcod);
		ActionDivers.type(num, mNum);
		
	ActionDivers.click(driver, createbtn);
		Thread.sleep(3000);
		ActionDivers.click(driver, continu);
		return new LoggedInPage();
	}
	
	public boolean validateAccntCreatnPage(){
		return ActionDivers.isDisplayed(driver, enterAccntInfrmatn);
	}
	
}
