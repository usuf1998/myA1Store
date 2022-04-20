package com.myA1store.testcases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.dataprovider.DataProviderrr;
import com.myA1store.base.Base;
import com.myA1store.pageobjects.HomePage;
import com.myA1store.pageobjects.IndexPage;
import com.myA1store.pageobjects.LoginPage;
import com.myA1store.utility.ExcelData;

public class LoginPageTest extends Base {
	 IndexPage ip;
	 LoginPage lp;
	 HomePage hp;
	 
	 @Parameters("browser")
	 @BeforeMethod(groups= {"smoke","sanity"})
	 public void setup(String browser) throws Throwable {
			lauchApp( browser);
		}
	@AfterMethod(groups= {"smoke","sanity"})
	public  void teardown() throws Throwable {
		
		getDriver().quit();
		
	}
	
	  @Test(dataProvider="sset",groups="sanity")
		public void verifyLogin(String user,String pass, String expe) throws Throwable {
		ip = new IndexPage();
		lp = new LoginPage();
		hp = new HomePage();
		lp =ip.validateSiginbutton();
		hp =lp.validateLogin(user, pass);
		String act =hp.currentUrl();
		String exp = "http://automationpractice.com/index.php?controller=my-account";
		if(expe.equals("valid")) {
			if(exp.equalsIgnoreCase(act)) {
				getDriver().findElement(By.className("logout")).click();
				Assert.assertTrue(true);
		}else {
			Assert.assertTrue(false);
		}
					 
		}else if(expe.equals("invalid")) {
			if(exp.equalsIgnoreCase(act)) {
				
				getDriver().findElement(By.className("logout")).click();
					Assert.assertTrue(false);
			}else {
				Assert.assertTrue(true);	
			}
		}
		
		
}
	   @DataProvider(name="sset")
		public String[][] set() throws Throwable {
			ExcelData xl = new ExcelData("/Users/syedyousufali/eclipse-workspace/myA1store/testData/user.xlsx");
			int to =xl.getRowCount("demo");
			int co = xl.getcellCount("demo", 0);
			String setData[][] = new String[to][co];
			for(int i=1;i<=to;i++) {
				for(int j=0;j<co;j++) {
				setData[i-1][j] =xl.getcellData("demo", i, j);
				}
			}
			return setData;
		}

}
