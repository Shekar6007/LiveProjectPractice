package com.LiveProject.Pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.LiveProject.Actions.ActionDivers;
import com.LiveProject.Base.BaseClass;

public class PaymentPage extends BaseClass{
	@FindBy(xpath="//*[@id='payment-form']/div[1]/div/input")
	WebElement nameOnCard;
	
	@FindBy(xpath="//*[@id='payment-form']/div[2]/div/input")
	WebElement cardNo;
	
	@FindBy(xpath="//*[@id='payment-form']/div[3]/div[1]/input")
	WebElement cvc;
	
	@FindBy(xpath="//*[@id='payment-form']/div[3]/div[2]/input")
	WebElement monthOnCard;
	
	@FindBy(xpath="//*[@id='payment-form']/div[3]/div[3]/input")
	WebElement yearOnCard;
	
	@FindBy(xpath="//*[@id='submit']")
	WebElement payAndConfirm;
	
	
	public PaymentPage(){
		PageFactory.initElements(driver, this);
	}
	
	public OrderConfirmPage enterCardDetails(String cardname,String cardNum,String cvcNo,String month,String year){
		ActionDivers.type(nameOnCard, cardname);
		ActionDivers.type(cardNo, cardNum);
		ActionDivers.type(cvc, cvcNo);
		ActionDivers.type(monthOnCard, month);
		ActionDivers.type(yearOnCard, year);
		ActionDivers.click(driver, payAndConfirm);
		return new OrderConfirmPage();
		
	}

}
