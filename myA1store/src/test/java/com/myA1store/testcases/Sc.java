package com.myA1store.testcases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.myA1store.action.Action;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Sc {
	static WebDriver driver;
	@Test
	public static void SSC() throws Throwable {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.google.com");
		driver.manage().window().maximize();
		Action.screenShot(driver, "hello");
	    driver.close();
	}

}
