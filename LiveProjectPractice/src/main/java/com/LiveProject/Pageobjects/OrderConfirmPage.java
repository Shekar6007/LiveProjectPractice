package com.LiveProject.Pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.LiveProject.Actions.ActionDivers;
import com.LiveProject.Base.BaseClass;


public class OrderConfirmPage extends BaseClass {

	@FindBy(xpath="//*[@id='form']/div/div/div/h2")
	WebElement orderPlacedmsg;
	
	@FindBy(xpath="//*[@id='form']/div/div/div/div/a")
	WebElement continueBtn;
	
	public OrderConfirmPage(){
		PageFactory.initElements(driver, this);
	}
	
	
	
	public boolean orderConfirmMsg(){
		return ActionDivers.isDisplayed(driver, orderPlacedmsg);
	}
	
	public LoggedInPage clickOnContinue(){
		ActionDivers.click(driver, continueBtn);
		return new LoggedInPage();
	}

}
