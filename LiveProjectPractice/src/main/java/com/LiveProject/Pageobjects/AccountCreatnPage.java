package com.LiveProject.Pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.LiveProject.Actions.ActionDivers;
import com.LiveProject.Base.BaseClass;

public class AccountCreatnPage extends BaseClass {

	@FindBy(xpath="//*[@id='form']/div/div/div/div[1]/h2/b")
	WebElement enterAccntInfrmatn;
	
	public AccountCreatnPage(){
		PageFactory.initElements(driver, this);
	}
	
	public boolean validateAccntCreatnPage(){
		return ActionDivers.isDisplayed(driver, enterAccntInfrmatn);
	}
	
}
