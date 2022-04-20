package com.myA1store.utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.myA1store.base.Base;

public class ExtentReprot extends Base{
	public static ExtentReports er;
	public static ExtentSparkReporter esr;
	public static ExtentTest test;
	public static  void extent() {
		 er = new ExtentReports();
		 esr = new ExtentSparkReporter("extent.html");
		esr.config().setTheme(Theme.DARK);
		esr.config().setDocumentTitle("MY A-1Store Report");
		esr.config().setReportName("End to End Test");
		er.attachReporter(esr);
	}
	public static void endReport() {
		er.flush();
	}
	 

}
