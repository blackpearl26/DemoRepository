 package utilities;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Screenshot {
	
	public String time()	{
		DateTimeFormatter d = DateTimeFormatter.ofPattern("dd-MMM-yyyy (HH-mm-ss)");
		LocalDateTime current = LocalDateTime.now();
		String time = d.format(current);
		return time;
	}
	
	
	public void getScreenshot(WebDriver driver, String name) throws IOException	{
		String time = time();
		File source =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File destination = new File("D:\\automation\\KiteZerodha\\Screenshots\\"+name+time+".jpeg");
		FileHandler.copy(source, destination);
	}
	
	public static void main(String[] args) {
		Screenshot obj = new Screenshot();
		System.out.println(obj.time());
	}

}
