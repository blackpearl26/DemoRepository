package test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import utilities.Screenshot;

public class TestListen implements ITestListener{
      WebDriver driver;

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		try {
			//method for completing driver
			driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (Exception e) {
		}

		try {
			Screenshot.getScreenshot(driver, result.getMethod().getMethodName());
		}
		catch(IOException e)	{
			e.printStackTrace();
		}
	}




}
