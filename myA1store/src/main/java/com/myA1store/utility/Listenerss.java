package com.myA1store.utility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.myA1store.action.Action;
import com.myA1store.base.Base;

public class Listenerss extends Base implements ITestListener{

	@Override
	public void onTestStart(ITestResult result) {
		ExtentReprot.test =ExtentReprot.er.createTest(result.getName());
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		ExtentReprot.test.pass(result.getName());
		ExtentReprot.test.createNode(result.getName());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		if(result.getStatus()==ITestResult.FAILURE) {
			ExtentReprot.test.log(Status.FAIL, "test case is failed "+result.getName());
		String img =Action.screenShot(getDriver(), result.getName());
		ExtentReprot.test.fail("screenshot is attached", MediaEntityBuilder.createScreenCaptureFromPath(img).build());
		
		}
		}

	@Override
	public void onTestSkipped(ITestResult result) {
		ExtentReprot.test.log(Status.SKIP, "skip the test "+result.getName());
	
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
	}

	@Override
	public void onStart(ITestContext context) {
	}

	@Override
	public void onFinish(ITestContext context) {
	}

}
