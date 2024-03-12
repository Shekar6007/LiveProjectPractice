package com.LiveProject.Pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.LiveProject.Actions.ActionDivers;
import com.LiveProject.Base.BaseClass;


public class AddressPage extends BaseClass {

	@FindBy(xpath="//*[@id='cart_items']/div/div[7]/a")
	WebElement placeOrder;
	
	@FindBy(xpath="//*[@id='cart_items']/div/div[4]/h2")
	WebElement addresspgMsg;
	
	
	public AddressPage(){
		PageFactory.initElements(driver, this);
	}
	
	public PaymentPage clickOnPlaceOrder(){
		ActionDivers.click(driver, placeOrder);
		return new PaymentPage();
	}
	
	public boolean addressMsgTest(){
		return ActionDivers.isDisplayed(driver, addresspgMsg);
		
	}
}
