package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel {
	
	public static String getData(String sheetName, int row, int column) throws EncryptedDocumentException, IOException	{
		FileInputStream file = new FileInputStream("D:\\automation\\KiteZerodha\\src\\test\\resources\\test data.xlsx");
		String data = WorkbookFactory.create(file).getSheet(sheetName).getRow(row).getCell(column).getStringCellValue();
		return data;
	}

}
