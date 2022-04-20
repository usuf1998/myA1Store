package com.myA1store.testcases;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class TakeSc {
 
	public static void SSCc(WebDriver driver,String filname) throws Throwable {
		String dataName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source =ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("/Users/syedyousufali/eclipse-workspace/myA1store/screenshots/"+filname+"_"+dataName+".png"));
	    Thread.sleep(2000);
	}
}
