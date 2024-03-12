package com.LiveProject.Pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.LiveProject.Actions.ActionDivers;
import com.LiveProject.Base.BaseClass;


public class SearchResultPage extends BaseClass {

	@FindBy(xpath="/html/body/section[2]/div/div/div[2]/div/div[2]/div/div[1]/div[1]/img")
	WebElement imgOfProduct;

	@FindBy(xpath="/html/body/section[2]/div/div/div[2]/div/div[2]/div/div[2]/ul/li/a")
	WebElement viewProduct;
	
	public SearchResultPage(){
		PageFactory.initElements(driver, this);
	}
	
	public boolean isProductAvailable(){
		return ActionDivers.isDisplayed(driver, imgOfProduct);
		
	}
	public AddToCartPage clickOnviewProduct(){
		ActionDivers.click(driver, viewProduct);
		return new AddToCartPage();
	}
	
}
