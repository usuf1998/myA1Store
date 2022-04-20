package com.myA1store.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.myA1store.action.Action;
import com.myA1store.base.Base;

public class HomePage extends Base{
	@FindBy(xpath="//*[@id=\"center_column\"]/div/div[2]/ul/li/a/span")WebElement wishlist;
	@FindBy(xpath="//*[@id=\"center_column\"]/div/div[1]/ul/li[1]/a/span")WebElement orderhistory;
	public HomePage() {
		PageFactory.initElements(getDriver(), this);
	}
	public boolean validateorderhistory() throws Throwable {
		return Action.isDisplayed(getDriver(), orderhistory);
	}

	public boolean validateWishlist() throws Throwable {
		return Action.isDisplayed(getDriver(), wishlist);
	}
	public String currentUrl() {
		String hpurl =getDriver().getCurrentUrl();
		return hpurl;
	}
}
