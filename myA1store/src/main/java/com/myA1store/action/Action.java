package com.myA1store.action;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.myA1store.base.Base;

public class Action extends Base{
	public static void click(WebDriver idriver,WebElement ele) throws Exception{
		Actions act = new Actions(idriver);
		act.moveToElement(ele).click().perform();
	}
	public void scrollByVisibility(WebDriver driver, WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", ele);
	}
	
	public static boolean findElement(WebDriver idriver,WebElement ele) throws Exception {
		boolean flag = false;
		try {
		ele.isDisplayed();
		flag = true;
		}catch (Exception e) {
			flag = false;
		}
		finally {
			if(flag) {
				System.out.println("element found successfully");
			}else {
				System.out.println("element not found");
			}
		}
		return flag;
	}
	
	public static boolean isDisplayed(WebDriver idriver,WebElement ele) throws Exception{
		boolean flag = false;
		flag =findElement(idriver,ele);
		if(flag) {
			flag = ele.isDisplayed();
			if(flag) {
				System.out.println("element is displayed");
			}else {
				System.out.println("element not displayed");
			}
		}else {
			System.out.println("not displayed");
		}
		return flag;
		
	}
	
	public static boolean isSelected(WebDriver idriver,WebElement ele) throws Exception{
		boolean flag = false;
		flag = findElement(idriver,ele);
		if(flag) {
			flag = ele.isSelected();
			if(flag) {
				System.out.println("element is selected");
			}else {
				System.out.println("element is not selected");
			}
		}else {
			System.out.println("element not selected");
		}
		return flag;
	}
	public static boolean isEnabled(WebDriver idriver,WebElement ele) throws Exception{
		boolean flag = false;
		flag = findElement(idriver,ele);
		if(flag) {
			flag = ele.isEnabled();
			if(flag) {
				System.out.println("element is Enabled");
			}else {
				System.out.println("element is not Enabled");
			}
		}else {
			System.out.println("element not Enabled");
		}
		return flag;
	}
	public static boolean sendKeys(WebElement ele, String text)throws Exception{
		boolean flag =false;
		try {
		flag =ele.isDisplayed();
		ele.clear();
		ele.sendKeys(text);
		flag = true;
		}catch(Exception e) {
			flag = false;
		}finally {
			if(flag) {
				System.out.println("sucessfully entered value");
			}else {
				System.out.println("unable to enter value");
			}
		}
		return flag;
	}
	
	public static boolean selectBySendKeys(WebElement ele, String text) throws Throwable{
		boolean flag = false;
		try {
		ele.sendKeys(text);
		flag = true;
		
		}catch(Exception e) {
			flag = false;
		}finally {
			if(flag) {
				System.out.println("selected value from drop down");
			}else {
				System.out.println("not selected value from drop down");
			}
			
		}
		return flag;
	}
	public static boolean selectByIndex(WebElement ele,int index) throws Throwable{
		boolean flag = false;
		try {
			Select s = new Select(ele);
			s.selectByIndex(index);
			flag = true;
		}catch (Exception e) {
			flag = false;
		}finally {
			if(flag) {
				System.out.println("option selected by index");
			}else {
				System.out.println("option not selected by index");
			}
		}
		return flag;
	}
	public static boolean selectByVisibleText(WebElement ele,String text) throws Throwable{
		boolean flag = false;
		try {
			Select s = new Select(ele);
			s.selectByVisibleText(text);
			flag = true;
			
		}catch (Exception e) {
			flag = false;
		}
		finally {
			if(flag) {
				System.out.println("option selected by visible text");
			}else {
				System.out.println("option not selected by visible text");
			}
		}
		return flag;
		
	}
	public static boolean clickbyJs(WebDriver idriver,WebElement ele)throws Throwable {
		boolean flag = false;
		try {
		JavascriptExecutor js = (JavascriptExecutor)idriver;
		js.executeScript("arguments[0].click();", ele);
		flag = true;
		}catch (Exception e) {
			flag = false;
		}finally {
			if(flag) {
				System.out.println("click action performed by js");
			}else {
				System.out.println("click action not performed by js");
			}
			
		}
		return flag;
	}
	
	public static boolean switchToFrameByIndex(int index,WebDriver idriver)throws Throwable {
		boolean flag = false;
		try {
			idriver.switchTo().frame(index);
			flag = true;
		}catch(Exception e) {
			flag = false;
		}
		finally {
			if(flag) {
				System.out.println("Frame with index : "+index+" is selected");
			}else {
				System.out.println("Frame with index : "+index+" is not selected");
			}
		}
		return flag;
	}

	public static boolean switchToFrameById(String idvalue,WebDriver idriver) throws Throwable{
		boolean flag = false;
		try {
			idriver.switchTo().frame(idvalue);
			flag = true;
		}catch(Exception e) {
			flag = false;
		}
		finally {
			if(flag) {
				System.out.println("Frame with id : "+idvalue+" is selected");
			}else {
				System.out.println("Frame with id : "+idvalue+" is not selected");
			}
		}
		return flag;
	}
	public static boolean switchToFrameByName(String namevalue,WebDriver idriver) throws Throwable{
		boolean flag = false;
		try {
			idriver.switchTo().frame(namevalue);
			flag = true;
		}catch(Exception e) {
			flag = false;
		}
		finally {
			if(flag) {
				System.out.println("Frame with name : "+namevalue+" is selected");
			}else {
				System.out.println("Frame with name : "+namevalue+" is not selected");
			}
		}
		return flag;
	}
	public static boolean switchToDefalut(WebDriver idriver) throws Throwable{
		boolean flag = false;
		try {
			idriver.switchTo().defaultContent();
			flag = true;
		}catch(Exception e) {
			flag = false;
		}
		finally {
			if(flag) {
				System.out.println("defalut Frame  is selected");
			}else {
				System.out.println("defalut Frame  is not selected");
			}
		}
		return flag;
	}
	public static boolean mouseOverElement(WebElement ele,WebDriver idriver) {
		boolean flag = false;
		try {
		Actions act = new Actions(idriver);
		act.moveToElement(ele).perform();
		flag = true;
		}catch(Exception e) {
			flag = false;
		}finally {
			if(flag) {
				System.out.println("mouseover performed successfully");
			}else {
				System.out.println("mouseover performed successfully");
			}
		}
		return flag;
	}
	
	public static String screenShot(WebDriver driver, String filename) {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destination = "/Users/syedyousufali/eclipse-workspace/myA1store/screenshots/"+filename+"_"+dateName+".png";

		try {
			FileUtils.copyFile(source, new File(destination));
		} catch (Exception e) {
			e.getMessage();
		}
		// This new path for jenkins
		//String newImageString = "http://localhost:8082/job/MyStoreProject/ws/MyStoreProject/ScreenShots/" + filename + "_"
		//		+ dateName + ".png";
		return destination;
	}


}
