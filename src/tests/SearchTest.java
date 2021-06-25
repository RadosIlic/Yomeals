package tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SearchTest extends BaseTest{

	private BaseTest baseTest;
	
	@Test
	private void searchResult() throws IOException, InterruptedException {
		
		File file = new File("./data/data(1).xlsx");
		
		FileInputStream fis = new FileInputStream(file);
		
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		
		XSSFSheet sheet = wb.getSheetAt(0);
		
		SoftAssert softAssert = new SoftAssert();
		
		//Landing page
		driver.get(baseUrl + "meals");
		
		//Select "City Center - Albany" location
		locationPopupPage.selectLocation("City Center - Albany");
		
		Thread.sleep(2000);
		
		int rows = sheet.getLastRowNum();
		for (int i = 1; i <= rows; i++) {
			String location = sheet.getRow(i).getCell(0).getStringCellValue();
			String mealUrl = sheet.getRow(i).getCell(1).getStringCellValue();
			int noOfResults = (int) sheet.getRow(i).getCell(2).getNumericCellValue();
			
			locationPopupPage.openPopupLocation();
			locationPopupPage.selectLocation(location);
			
			// To do: implement search results and assert
		}
		

	}
}
