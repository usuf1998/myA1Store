package com.myA1store.testcases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.myA1store.base.Base;
import com.myA1store.pageobjects.IndexPage;
import com.myA1store.pageobjects.LoginPage;
import com.myA1store.utility.ExtentReprot;
import com.myA1store.utility.ScreenShot;

public class IndexPageTest extends Base{
    IndexPage ip;
	LoginPage lp;
	
	
	@Parameters("browser")
	@BeforeMethod(groups= {"smoke","sanity"})
	public void setup(String browser) throws Throwable {
		lauchApp( browser);
	}
	@AfterMethod(groups= {"smoke","sanity"})
	public  void teardown() throws Throwable {
		
		getDriver().quit();
	}
	
	@Test(priority =2,groups="smoke")
	public void verifyLogo() throws Throwable {
		
		ip = new IndexPage();
		ExtentReprot.test.info("validating logo");
		boolean result =ip.validateLogo();
		ExtentReprot.test.info("verifying logo");
		Assert.assertTrue(false);
		
	}
	@Test(priority =1)
	public void verfiyTitle() {
		ip = new IndexPage();
		String actTitle =ip.validateStoreTitle();
		String exp ="My Store";
		AssertJUnit.assertEquals(actTitle,exp);
	}
	

}
