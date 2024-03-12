package com.LiveProject.Pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.LiveProject.Actions.ActionDivers;
import com.LiveProject.Base.BaseClass;


public class AddToCartPage extends BaseClass{
	
	@FindBy(id="quantity")
	WebElement itemQuantity;

	@FindBy(xpath="/html/body/section/div/div/div[2]/div[2]/div[2]/div/span/button")
	WebElement addToCartBtn;
	
	@FindBy(xpath="//*[@id='cartModal']/div/div/div[2]/p[2]/a/u")
	WebElement viewCart;
	
	
	
	public AddToCartPage(){
		PageFactory.initElements(driver, this);
	}
	
	public OrderOrProceedPAge addItemsToCart(String noOfItems) throws InterruptedException{
		ActionDivers.type(itemQuantity,noOfItems );
		ActionDivers.click(driver, addToCartBtn);
		Thread.sleep(3000);
		ActionDivers.click(driver, viewCart);
		return new OrderOrProceedPAge();
	}


}
