package test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import POM.Buy;
import POM.Homepage;
import POM.loginPage;
import pojo.OpenBrowser;
import utilities.Excel;
import utilities.Reports;

public class LongtermOrders {
	WebDriver driver;
	ExtentReports reports;
	ExtentTest test;
	@BeforeClass
	
	public void configureExtentReport()	{
		reports = Reports.addReport();
	}
	
	@BeforeMethod
	public void launchBrowser() throws EncryptedDocumentException, IOException	{
		driver = OpenBrowser.ChromeBrowser("https://kite.zerodha.com/");
		loginPage loginpage = new loginPage(driver);
		String userID = Excel.getData("Zerodha", 1, 0);
		loginpage.enterUserName(userID);
		String pass = Excel.getData("Zerodha", 1, 1);
		loginpage.enterPassword(pass);
		loginpage.clickLogin();
		String pinValue= Excel.getData("Zerodha", 1, 2);
		loginpage.enterPin(driver, pinValue);
		loginpage.clickContinue();
	}
	////////////////////////////////////////////
	@DataProvider		(name="stocks")
	public Object[][] data()	{
		return new Object[][] {{"INFY","BSE","3","1555","1545"},{"WIPRO","NSE","6","490","480"}};
	}
	
	@Test	(dataProvider = "stocks")
	public void stoplossOrder(String stockName, String exchangeName,String qty, String amount, String triggerAmount)	{
		test = reports.createTest("stoplossOrder");
		Homepage homepage = new Homepage(driver);
		homepage.enterStockName(driver, stockName);
		homepage.clickOnBuy(driver, stockName, exchangeName);
		Buy buy = new Buy(driver);
		buy.selectIntraday(driver);
		buy.selectNse(driver);
		buy.selectStoploss(driver);
		buy.setQty(driver, qty);
		buy.setPrice(driver, amount);
		buy.setTriggerPrice(driver, triggerAmount);
		buy.clickOnBuy();
		homepage.clickOnLogout(driver);
		
	}
	////////////////////////////////////////////////
	
	@DataProvider	(name="marketorders")
	public Object[][] data1()	{
		return new Object [][] {{"HDFCBANK","BSE","5"},{"PAYTM","NSE","2"}};
	}
	@Test	(dataProvider = "marketorders")
	public void marketOrder(String stockName, String exchangeName, String qty)	{
		test = reports.createTest("marketOrder");
		Homepage homepage = new Homepage(driver);
		homepage.enterStockName(driver, stockName);
		homepage.clickOnBuy(driver, stockName, exchangeName);
		Buy buy = new Buy(driver);
		buy.selectMarket(driver);
		buy.setQty(driver, qty);
		buy.clickOnBuy();
	}
	////////////////////////////////////////////////
	
	@DataProvider		(name="SL-M order")
	public Object [][] data2()	{
		return new Object[][]	{{"TATAMOTORS","BSE","5","400"}};
	}
	
	@Test	(dataProvider = "SL-M order")
	public void stoplossMarketOrder(String stockName, String exchangeName, String qty, String triggerAmount)	{
		test = reports.createTest("stoplossMarketOrder");
		Homepage homepage = new Homepage(driver);
		homepage.enterStockName(driver, stockName);
		homepage.clickOnBuy(driver, stockName, exchangeName);
		Buy buy = new Buy(driver);
		buy.selectLongterm(driver);
		buy.selectStoplossMarket(driver);
		buy.setQty(driver, qty);
		buy.setTriggerPrice(driver, triggerAmount);
		buy.clickOnBuy();
	}
	//////////////////////////////////////////////////////
	@DataProvider	(name = "limitr order")
	public Object [][] data3()	{
		return new Object[][]	{{"TATAPOWER","BSE","10","230"}};
	}
	@Test	(dataProvider = "limitr order")
	public void limitOrder(String stockName, String exchangeName, String qty, String amount)	{
		test = reports.createTest("limitOrder");
		Homepage homepage = new Homepage(driver);
		homepage.enterStockName(driver, stockName);
		homepage.clickOnBuy(driver, stockName, exchangeName);
		Buy buy = new Buy(driver);
		buy.selectLongterm(driver);
		buy.selectLimit(driver);
		buy.setQty(driver, qty);
		buy.setPrice(driver, amount);
		buy.clickOnBuy();
	}
	
	@AfterMethod
	public void addTestResult(ITestResult result)	{
		if(result.getStatus()==ITestResult.FAILURE)	{
			test.log(Status.FAIL, result.getName());
		}
		else if(result.getStatus()==ITestResult.SUCCESS)	{
			test.log(Status.PASS, result.getName());
		}
		else	{
			test.log(Status.SKIP, result.getName());
		}
	}
	
	@AfterClass
	public void flushResults()	{
		reports.flush();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
