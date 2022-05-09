 package utilities;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Screenshot {
	
	public static String time()	{
		DateTimeFormatter d = DateTimeFormatter.ofPattern("dd-MMM-yyyy (HH-mm-ss)");
		LocalDateTime current = LocalDateTime.now();
		String time = d.format(current);
		return time;
	}
	
	
	public static void getScreenshot(WebDriver driver, String name) throws IOException	{
		String time = time();
		File source =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir")+"\\Failed\\"+name+".png";
		System.out.println(path);
		FileUtils.copyFile(source, new File(path));
	}
	
	public static void main(String[] args) {
		Screenshot obj = new Screenshot();
		System.out.println(obj.time());
	}

}
