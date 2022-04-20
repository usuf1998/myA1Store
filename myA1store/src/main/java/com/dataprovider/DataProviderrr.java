package com.dataprovider;


import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;

import com.myA1store.base.Base;
import com.myA1store.utility.ExcelData;

public class DataProviderrr extends Base {
	
	
	
	
	@DataProvider(name = "xldataa")
	
	public Object[][] readExcelData() throws Exception {
		String pathh = "/Users/syedyousufali/eclipse-workspace/myA1store/testData/user1.xlsx";
		ExcelData xl = new ExcelData(pathh);
		int row =xl.getRowCount("sheet1");
		int col =xl.getcellCount("sheet1", 1);
		Object  dataExcel[][] = new Object[row][col];
		for(int i=0;i<=row;i++) {
			for(int j=0;j<=col;j++) {
				
				 dataExcel [i][j] =xl.getcellData("sheet1", row, col);
				 
			}
		}
		return dataExcel;
		
		
	}
	@DataProvider(name ="logindataa")
	public  Object[][] getData() {
		Object logindata[][]= {{"you@gmail.com","qwerty11","valid"},
				{"youu@gmail.com","qwerty11","invalid"},
				{"you@gmail.com","qwerty111","invalid"},
				{"youu@gmail.com","qwerty112","invalid"}
				
		};
		return logindata;
	}
	/*if(expe.equals("valid")) {
		if(exp.equalsIgnoreCase(act)) {
			driver.findElement(By.className("logout")).click();
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
		}
	}else if(expe.equals("invalid")) { 
		if(exp.equalsIgnoreCase(act)) {
			driver.findElement(By.className("logout")).click();
			Assert.assertTrue(false);
		}else {
			Assert.assertTrue(true);
		}
	
	*/

}
