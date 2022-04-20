/**
 * 
 */
package com.myA1store.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.myA1store.utility.ExtentReprot;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author syedyousufali
 *
 */
public class Base {
	public static Properties prop;
	//public static WebDriver driver;
	public static ThreadLocal<RemoteWebDriver> driver =new ThreadLocal<>();
	
	public static WebDriver getDriver() {
		return driver.get();
	}
	@BeforeSuite(groups= {"smoke","sanity"})
     public void extentRep() {
		ExtentReprot.extent();
	}
	@AfterSuite(groups= {"smoke","sanity"})
	public void afterSuit() {
		ExtentReprot.endReport();
	}
	@BeforeTest(groups= {"smoke","sanity"})
	public void loadConfig() throws Exception {
		prop = new Properties();
			FileInputStream fi = new FileInputStream(System.getProperty("user.dir")+"/configuration/config.properties");
		prop.load(fi);
		
		
	}
	
	public static void lauchApp(String browsername) throws Exception {
		//String browsername =prop.getProperty("browser");
		if(browsername.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver.set(new ChromeDriver());
		}else if(browsername.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver.set(new FirefoxDriver()); 
		}else if(browsername.equalsIgnoreCase("safari")) {
			WebDriverManager.safaridriver().setup();
			driver.set(new SafariDriver());
		}
		getDriver().get(prop.getProperty("url"));
		getDriver().manage().window().maximize();
		Thread.sleep(2000);
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	public  void SSCc(WebDriver driver,String filname) throws Throwable {
		String dataName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot)getDriver();
		File source =ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("/Users/syedyousufali/eclipse-workspace/myA1store/screenshots/"+filname+"_"+dataName+".png"));
	   
	}
	

}
