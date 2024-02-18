package com.ecom.listenerUtility;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;

import genericUtility.BaseClass;

public class ListenerImplementation extends BaseClass implements ITestListener{

	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, result.getName()+" test Script passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		TakesScreenshot ts=(TakesScreenshot) driver;
		String errorshot = ts.getScreenshotAs(OutputType.BASE64);
		test.addScreenCaptureFromBase64String(errorshot);
		test.log(Status.FAIL, result.getName()+" test Script failed");
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, result.getName()+" test Script skipped");
	}
	

}
