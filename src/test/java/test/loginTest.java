package test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import POM.loginPage;
import pojo.OpenBrowser;
import utilities.Excel;

public class loginTest {
	WebDriver driver;
	
	@BeforeMethod
	public void launchBrowser()	{
		driver =OpenBrowser.ChromeBrowser("https://kite.zerodha.com/");
	}
	
	@Test
	public void loginWithValidInput() throws EncryptedDocumentException, IOException	{
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
	

}
