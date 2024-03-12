package com.LiveProject.Pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.LiveProject.Actions.ActionDivers;
import com.LiveProject.Base.BaseClass;


public class SearchPage extends BaseClass{

	@FindBy(id="search_product")
	WebElement searchBox;
	
	@FindBy(id="submit_search")
	WebElement searchBtn;
	
	public SearchPage(){
		PageFactory.initElements(driver, this);
	}
	
	public SearchResultPage searchBoxFunction(String ProductName){
		ActionDivers.type(searchBox, ProductName);
		ActionDivers.click(driver, searchBtn);
		return new SearchResultPage();
	}
	
	
	
}
