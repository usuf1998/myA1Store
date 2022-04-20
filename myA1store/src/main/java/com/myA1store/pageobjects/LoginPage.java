package com.myA1store.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.myA1store.action.Action;
import com.myA1store.base.Base;

public class LoginPage extends Base{
	
	@FindBy(id="email")WebElement enterusername;
	@FindBy(id="passwd")WebElement enterpassword;
	@FindBy(id="SubmitLogin")WebElement clickonloginbtn;
	@FindBy(id="email_create")WebElement newaccountenteremail;
	@FindBy(id="SubmitCreate")WebElement clickonsubmitbtn;
	public LoginPage() {
		PageFactory.initElements(getDriver(), this);
	}
	public HomePage validateLogin(String username,String password) throws Throwable {
		Action.sendKeys(enterusername, username);
		Action.sendKeys(enterpassword, password);
		Action.click(getDriver(), clickonloginbtn);
		return new HomePage();
	}
	public AccountCreationPage validatenewaccount() throws Throwable {
		Action.sendKeys(newaccountenteremail, "yous@gmail.com");
		Action.click(getDriver(), clickonsubmitbtn);
		return new AccountCreationPage();
		
	}
	

}
