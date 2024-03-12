package com.LiveProject.Pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.LiveProject.Actions.ActionDivers;
import com.LiveProject.Base.BaseClass;


public class LoggedInPage extends BaseClass{
	
	@FindBy(xpath="//*[@id='header']/div/div/div/div[2]/div/ul/li[4]/a")
	WebElement logoutBtn;
	
	@FindBy(xpath="//*[@id='header']/div/div/div/div[2]/div/ul/li[3]/a")
	WebElement cartBtn;
	
	@FindBy(xpath="//*[@id='header']/div/div/div/div[2]/div/ul/li[2]/a")
	WebElement productbtn;
	
	/*@FindBy(xpath="")
	WebElement crossX;*/
	
	public LoggedInPage(){
		PageFactory.initElements(driver, this);
	}

	public String getCurrUrl(){
		
		String LogedInpageurl=driver.getCurrentUrl();
		return LogedInpageurl;
	}
	
	public SignUpPage logoutFunction(){
	ActionDivers.click(driver, logoutBtn);
	return new SignUpPage();
    }
	
	public OrderOrProceedPAge clickOnCartBtn(){
		ActionDivers.click(driver, cartBtn);
		return new OrderOrProceedPAge();
	}
	
	public SearchPage clickOnProducts() throws InterruptedException{
		ActionDivers.click(driver, productbtn);
		Thread.sleep(5000);
		
		return new SearchPage();
	}
	

}
