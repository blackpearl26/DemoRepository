package POM;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.Excel;

public class Homepage {
	@FindBy(xpath="//input[@icon='search']") private WebElement searchbar;
	@FindBy(xpath="//span[@class='icon icon-plus']") private WebElement add;
	@FindBy(xpath="//button[@class='button-blue buy']") private WebElement watchlistBuy;
	@FindBy(xpath="//button[@class='button-orange sell']") private WebElement watchlistSell;
	@FindBy(xpath="//button[@class='submit']") private WebElement finalBuy;
	@FindBy(xpath="//ul//button[@class='button-blue']") private WebElement searchBuy;
	@FindBy(xpath="//button[@class='button-orange']") private WebElement searchSell;
	@FindBy(xpath="//button/span[@class='icon icon-trending-up']" ) WebElement chart;
	@FindBy(xpath="//span[text()='Orders']") private WebElement orders;
	@FindBy(xpath="//span[text()='Holdings']") private WebElement holdings;
	@FindBy(xpath="//span[text()='Dashboard']") private WebElement dashboard;
	@FindBy(xpath="//span[text()='Positions']") private WebElement positions;
	@FindBy(xpath="//span[text()='Funds']") private WebElement funds;
	@FindBy(xpath="//div[@class='right-nav']/div/a") private WebElement id;
	@FindBy(xpath="//ul[@class='list-flat dropdown-nav-list']//li/a[@href='/logout']") private WebElement logout;
	@FindBy(xpath="//span[@class='icon icon-times close']") private WebElement close;
	@FindBy(xpath="//ul[@class='omnisearch-results']//span[@class='company']") private List<WebElement> companyNameList;
	@FindBy(xpath="//ul[@class='omnisearch-results']//span[contains(@class,'exchange-tag')]") private List<WebElement> exchangeList;
	@FindBy(xpath="//ul[@class='omnisearch-results']//span[@class='tradingsymbol']") private List<WebElement> symbolList;
	
	
	public Homepage(WebDriver driver)	{
		PageFactory.initElements(driver, this);
	}
	
	public void enterStockName(WebDriver driver, String stockName)	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofMillis(5000));
		wait.until(ExpectedConditions.visibilityOf(searchbar));
		searchbar.sendKeys(stockName);
	}
	
	
	public void clickOnAddToWatchlist(WebDriver driver, String stockName, String exchangeName)	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofMillis(5000));
		wait.until(ExpectedConditions.visibilityOfAllElements(companyNameList));
		
		for(int symbolIndex=0; symbolIndex<symbolList.size();symbolIndex++)	{
			
			for(int excIndex=0; excIndex<exchangeList.size(); excIndex++)	{
				String symbol = symbolList.get(symbolIndex).getText();
				String exchange = exchangeList.get(excIndex).getText();
				if(symbol.equalsIgnoreCase(stockName) && exchange.equalsIgnoreCase(exchangeName))	{
					Actions act = new Actions(driver);
					act.moveToElement(exchangeList.get(excIndex));
					act.perform();
					add.click();
			}
			}
		}
	}
	
			
		
	public void clickOnBuy(WebDriver driver, String stockName, String exchangeName)	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofMillis(5000));
		wait.until(ExpectedConditions.visibilityOfAllElements(companyNameList));
		for(int symbolIndex=0; symbolIndex<symbolList.size();symbolIndex++)	{
			
			for(int excIndex=0; excIndex<exchangeList.size(); excIndex++)	{
				String symbol = symbolList.get(symbolIndex).getText();
				String exchange = exchangeList.get(excIndex).getText();
				if(symbol.equalsIgnoreCase(stockName) && exchange.equalsIgnoreCase(exchangeName))	{
					Actions act = new Actions(driver);
					act.moveToElement(exchangeList.get(excIndex));
					act.perform();
					searchBuy.click();
				}
			}
		}
	}
	
	
	public void clickOnChart(WebDriver driver, String stockName, String exchangeName)	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofMillis(5000));
		wait.until(ExpectedConditions.visibilityOfAllElements(companyNameList));
		for(int symbolIndex=0; symbolIndex<symbolList.size();symbolIndex++)	{
			
			for(int excIndex=0; excIndex<exchangeList.size(); excIndex++)	{
				String symbol = symbolList.get(symbolIndex).getText();
				String exchange = exchangeList.get(excIndex).getText();
				if(symbol.equalsIgnoreCase(stockName) && exchange.equalsIgnoreCase(exchangeName))	{
					Actions act = new Actions(driver);
					act.moveToElement(exchangeList.get(excIndex));
					act.perform();
					chart.click();
				}
			}
		}
	}
	
	public void clickOnLogout(WebDriver driver)	{
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(close));
		id.click();
		close.click();
		logout.click();
	}
	
	
	
	
	
}
