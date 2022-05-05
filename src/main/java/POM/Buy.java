package POM;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Buy {
	@FindBy(xpath ="//div[@class='exchange-selector']//input[@value='BSE']") private WebElement bse;
	@FindBy(xpath ="//div[@class='exchange-selector']//input[@value='NSE']") private WebElement nse;
	@FindBy(xpath ="//label[@class='su-switch-control']") private WebElement toggleSwitch;
	@FindBy(xpath ="//input[@value='MIS']") private WebElement intraday;
	@FindBy(xpath ="//input[@value='CNC']") private WebElement longterm;
	@FindBy(xpath ="//input[@label='Qty.']") private WebElement quantity;
	@FindBy(xpath ="//input[@label='Price']") private WebElement price;
	@FindBy(xpath ="//input[@label='Market']") private WebElement market;
	@FindBy(xpath ="//input[@label='Limit']") private WebElement limit;
	@FindBy(xpath ="//input[@label='SL']") private WebElement stoploss;
	@FindBy(xpath ="//input[@label='SL-M']") private WebElement stoplossMarket;
	@FindBy(xpath ="//button[@type='submit']") private WebElement buyButton;
	@FindBy(xpath ="//input[@label='Trigger price']") private WebElement triggerPrice;
	@FindBy(xpath ="//button[@class='button-outline cancel']") private WebElement cancelButton;
	
	public Buy(WebDriver driver)	{
		PageFactory.initElements(driver, this);
	}
	
	public void selectBse(WebDriver driver)	{
		JavascriptExecutor js = (JavascriptExecutor)driver; 
		js.executeScript("arguments[0].click();", bse);
	}
	
	public void selectNse(WebDriver driver)	{
		JavascriptExecutor js = (JavascriptExecutor)driver; 
		js.executeScript("arguments[0].click();", nse);
	}
	
	public void selectIntraday(WebDriver driver)	{
		JavascriptExecutor js = (JavascriptExecutor)driver; 
		js.executeScript("arguments[0].click();", intraday);
	}
	
	public void selectLongterm(WebDriver driver)	{
		JavascriptExecutor js = (JavascriptExecutor)driver; 
		js.executeScript("arguments[0].click();", longterm);
	}
	
	public void setQty(WebDriver driver,String qty)	{
		Actions act = new Actions(driver);
		act.click(quantity);
		act.keyDown(Keys.CONTROL);
		act.sendKeys("a");
		act.keyUp(Keys.CONTROL);
		act.build().perform();
		quantity.sendKeys(qty);
	}
	
	public void setPrice(WebDriver driver, String amount)	{
		Actions act = new Actions(driver);
		act.click(price);
		act.keyDown(Keys.CONTROL);
		act.sendKeys("a");
		act.keyUp(Keys.CONTROL);
		act.build().perform();
		price.sendKeys(amount);
	}
	
	public void setTriggerPrice(WebDriver driver, String triggerAmount)	{
		Actions act = new Actions(driver);
		act.click(triggerPrice);
		act.keyDown(Keys.CONTROL);
		act.sendKeys("a");
		act.keyUp(Keys.CONTROL);
		act.build().perform();
		triggerPrice.sendKeys(triggerAmount);
	}
	
	public void selectMarket(WebDriver driver)	{   
	    JavascriptExecutor js = (JavascriptExecutor)driver; 
		js.executeScript("arguments[0].click();", market);
	}
	
	public void selectLimit(WebDriver driver)	{
		JavascriptExecutor js = (JavascriptExecutor)driver; 
		js.executeScript("arguments[0].click();", limit);
	}
	
	public void selectStoploss(WebDriver driver)	{
		JavascriptExecutor js = (JavascriptExecutor)driver; 
		js.executeScript("arguments[0].click();", stoploss);
	}
	
	public void selectStoplossMarket(WebDriver driver)	{
		JavascriptExecutor js = (JavascriptExecutor)driver; 
		js.executeScript("arguments[0].click();", stoplossMarket);
	}
	
	public void clickOnBuy()	{
		buyButton.click();
	}
	
	public void clickOnToggleKey()	{
		toggleSwitch.click();
	}
	
	
	
	
	
	
	
	
	
	
	
}
