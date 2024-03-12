package com.LiveProject.Pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.LiveProject.Actions.ActionDivers;
import com.LiveProject.Base.BaseClass;

public class SignUpPage extends BaseClass {

	@FindBy(xpath ="//*[@id='form']/div/div/div[3]/div/form/input[2]")
	WebElement   signUpName;
	
	@FindBy(xpath = "//*[@id='form']/div/div/div[3]/div/form/input[3]")
	WebElement signUpEmail  ;
	
	@FindBy(xpath = "//*[@id='form']/div/div/div[3]/div/form/button")
	WebElement   signUpBtn;
	
	@FindBy(xpath="//*[@id='form']/div/div/div[1]/div/form/input[2]")
	WebElement  loginUid ;
	
	@FindBy(xpath="//*[@id='form']/div/div/div[1]/div/form/input[3]")
	WebElement  loginPwd ;
	
	@FindBy(xpath = "//*[@id='form']/div/div/div[1]/div/form/button")
	WebElement   loginBtn;
	
	public SignUpPage(){
		PageFactory.initElements(driver, this);
	}
	
	public AccountCreatnPage signUpFunction(String name,String email) throws InterruptedException{
		ActionDivers.type(signUpName, name);
		ActionDivers.type(signUpEmail, email);
		ActionDivers.click(driver, signUpBtn);
		Thread.sleep(20000);
		
		return new AccountCreatnPage();

	}
	
	public LoggedInPage loginFunction(String uname, String upasswrd) throws InterruptedException{
		ActionDivers.type(loginUid, uname);
		ActionDivers.type(loginPwd, upasswrd);
		ActionDivers.click(driver, loginBtn);
		Thread.sleep(20000);
		return new LoggedInPage();
	}
	
}
