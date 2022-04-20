package com.myA1store.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.myA1store.action.Action;
import com.myA1store.base.Base;

public class IndexPage extends Base{
	@FindBy(xpath="//img[@class='logo img-responsive']")WebElement logo;
	@FindBy(className ="login")WebElement siginbutton;
	@FindBy(id ="search_query_top")WebElement searchbox;
	@FindBy(name ="submit_search")WebElement searchbutton;
	
 public IndexPage() {
	 PageFactory.initElements(getDriver(), this);
 }
 public boolean validateLogo() throws Throwable {
	return Action.isDisplayed(getDriver(), logo);
 }
 public LoginPage validateSiginbutton() throws Throwable {
	 Action.click(getDriver(), siginbutton);
	 return new LoginPage();
 }
 public SearchResultPage validateSearchbox() throws Throwable {
	 Action.sendKeys(searchbox, "t-shirts");
	 Action.click(getDriver(), searchbutton);
	 return new SearchResultPage();
 }
 public String validateStoreTitle() {
	String mystoreTitle =getDriver().getTitle();
	return mystoreTitle;
 }
}
