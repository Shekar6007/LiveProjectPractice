package com.LiveProject.Pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.LiveProject.Actions.ActionDivers;
import com.LiveProject.Base.BaseClass;


public class OrderOrProceedPAge extends BaseClass {
	
	@FindBy(xpath="//*[@id='do_action']/div[1]/div/div/a")
	WebElement proceedToCheckout;
	
	@FindBy(xpath="//*[@id='checkoutModal']/div/div/div[2]/p[2]/a/u")
	WebElement registerorLogin;
	
	public OrderOrProceedPAge(){
		PageFactory.initElements(driver, this);
	}
	
	public AddressPage clickOnProceedToCheck(){
		ActionDivers.click(driver, proceedToCheckout);
		return new AddressPage();
		
	}
	
	public SignUpPage clickOnProceedToCheckByLogin(){
		ActionDivers.click(driver, proceedToCheckout);
		ActionDivers.click(driver, registerorLogin);
		return new SignUpPage();
		
	}
	

}
