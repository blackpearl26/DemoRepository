package test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import POM.Buy;
import POM.Homepage;
import POM.loginPage;
import pojo.OpenBrowser;
import utilities.Excel;

public class IntradayOrders {
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
	
	@DataProvider	(name="marketorders")
	public Object[][] data1()	{
		return new Object [][] {{"TECHM","BSE","5"},{"TITAN","NSE","2"}};
	}
	
	@Test (dataProvider="marketorders")
	public void marketOrder(String stockName, String exchangeName, String qty) {
		Homepage homepage = new Homepage(driver);
		homepage.enterStockName(driver, stockName);
		homepage.clickOnBuy(driver, stockName, exchangeName);
		Buy buy = new Buy(driver);
		buy.selectIntraday(driver);
		buy.selectMarket(driver);
		buy.setQty(driver, qty);
		buy.clickOnBuy();
		
		
	}
	

}
