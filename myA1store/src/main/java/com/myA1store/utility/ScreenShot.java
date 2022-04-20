package com.myA1store.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.myA1store.base.Base;

public class ScreenShot extends Base{
	public  void SSCc(WebDriver driver,String filname) throws Throwable {
		String dataName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source =ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("/Users/syedyousufali/eclipse-workspace/myA1store/screenshots/"+filname+"_"+dataName+".png"));
	   
	}

	
}