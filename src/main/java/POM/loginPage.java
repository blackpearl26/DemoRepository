package POM;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class loginPage {
	
	@FindBy(xpath="//img[@alt='Kite']") private WebElement kiteLogo;
	@FindBy(xpath="//input[@id='userid']") private WebElement username;
	@FindBy(xpath="//input[@id='password']") private WebElement password;
	@FindBy(xpath="//button[@type='submit']") private WebElement login;
	@FindBy(xpath="//a[text()='Forgot user ID or password?']") private WebElement forgotID;
	@FindBy(xpath="Don't have an account? Signup now!") private WebElement signup;
	@FindBy(xpath="//a[contains(@title,'Play store')]") private WebElement playstore;
	@FindBy(xpath="//a[contains(@title,'Apple store')]") private WebElement applestore;
	@FindBy(xpath="//a[@class='footer-logo']") private WebElement zerodhaImg;
	@FindBy(xpath="//input[@id='pin']") private WebElement pin;
	@FindBy(xpath="//button[@type='submit']") private WebElement submit;
	
	public loginPage(WebDriver driver)	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickKiteLogo()	{
		kiteLogo.click();
	}
	
	public void enterUserName(String userID)	{
		username.sendKeys(userID);
	}
	
	public void enterPassword(String pass)	{
		password.sendKeys(pass);
	}
	
	public void clickLogin()	{
		login.click();
	}
	
	public void clickForgotID()	{
		forgotID.click();
	}
	
	public void clickSignup()	{
		signup.click();
	}
	
	public void clickPlayStore()	{
		playstore.click();
	}
	
	public void clickAppleStore()	{
		applestore.click();
	}
	
	public void enterPin(WebDriver driver,String pinValue)	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofMillis(2000));
		wait.until(ExpectedConditions.visibilityOf(pin));
		pin.sendKeys(pinValue);
	}
	
	public void clickContinue()	{
		submit.click();
	}
	
	
	
}
