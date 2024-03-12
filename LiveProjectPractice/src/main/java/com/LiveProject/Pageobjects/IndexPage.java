package com.LiveProject.Pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.LiveProject.Actions.ActionDivers;
import com.LiveProject.Base.BaseClass;

public class IndexPage extends BaseClass{

	@FindBy(xpath="//*[@id='header']/div/div/div/div[2]/div/ul/li[4]/a")
	WebElement signIn;
	
	@FindBy(xpath="//*[@id='header']/div/div/div/div[2]/div/ul/li[2]/a")
	WebElement productsBtn;
	
	@FindBy(xpath="//*[@id='header']/div/div/div/div[1]/div/a/img")
	WebElement logo;
	
	public IndexPage(){
		PageFactory.initElements(driver, this);
	}
	
	public SignUpPage clickOnSignIn(){
		ActionDivers.click(driver, signIn);
		return new SignUpPage();
	}
	
	public boolean validateLogo(){
		return ActionDivers.isDisplayed(driver, logo);
	}
	
	public String getMyTitle(){
		String title=driver.getTitle();
		return title;
	}
	
	public SearchPage clickOnProductBtn(){
		ActionDivers.click(driver, productsBtn);
		return new SearchPage();
	}
	
}
