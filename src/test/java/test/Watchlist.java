package test;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import POM.Buy;
import POM.Homepage;
import POM.loginPage;
import pojo.OpenBrowser;
import utilities.Excel;

public class Watchlist {
	WebDriver driver;
	
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
	
	@DataProvider (name = "searchStock")
	public Object[][] data()	{
		return new Object[][] {{"INFY","BSE"},{"WIPRO","NSE"}};
	}
	
	@Test	(dataProvider = "searchStock")
	public void addStockToWatchlist(String stockName, String exchangeName)	{
		Homepage homepage = new Homepage(driver);
		homepage.enterStockName(driver, stockName);
		homepage.clickOnAddToWatchlist(driver, stockName, exchangeName);
	}
	
	@Test (dataProvider = "searchStock")
	public void viewChart(String stockName, String exchangeName)	{
		Homepage homepage = new Homepage(driver);
		homepage.enterStockName(driver, stockName);
		homepage.clickOnChart(driver, stockName, exchangeName);
	}
	
	////////////////////////////////////////////////////////////////////////
	
	@DataProvider (name = "buyStock")
	public Object[][] data2()	{
		return new Object[][] {{"WIPRO","BSE","3"}};
	}
	
	
	@Test	(dataProvider = "buyStock")
	public void searchAndBuyStock(String stockName, String exchangeName, String qty)	{
		Homepage homepage = new Homepage(driver);
		homepage.enterStockName(driver,stockName);
		homepage.clickOnBuy(driver, stockName, exchangeName);
		Buy buy = new Buy(driver);
		buy.selectMarket(driver);
		buy.clickOnBuy();	
	}
	
}
	

			
	

