package tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pages.CartSummaryPage;

public class MealItemTest extends BaseTest {

	private BaseTest baseTest;
	
	@Test(priority=1)
	public void mealToCart() throws InterruptedException {
		//Landing page
		driver.get(baseUrl + "meal/lobster-shrimp-chicken-quesadilla-combo");
		
		//Close popup location window
		locationPopupPage.getClosePopup().click();
		
		Thread.sleep(2000);
		
		//Adding meal to cart
		mealPage.addToCart(4);
		
		//Verify "The Following Errors Occurred" message
		String errorMessage = mealPage.getErrorMesage().getText();
		System.out.println(errorMessage);
		Assert.assertTrue(errorMessage.contains("The Following Errors Occurred"));
		
		//Setting "City Center - Albany" location
		Thread.sleep(4000);
		locationPopupPage.getLocation().click();
		locationPopupPage.selectLocation("City Center - Albany");
		
		Thread.sleep(2000);
		//Adding meal to cart
		mealPage.addToCart(4);
		
		//Verify "Meal Added To Cart" message
		Thread.sleep(1000);
		String mealAddedToCart = mealPage.getMealAddedToCartMessage().getText();
		System.out.println(mealAddedToCart);
		Assert.assertTrue(mealAddedToCart.contains("Meal Added To Cart"), "[ERROR] Unexpected error-Meal added message failed");
				
	}
	
	
	@Test(priority=1)
	public void addMealToFavourite() throws InterruptedException {
		//Landing page
		driver.get(baseUrl + "meal/lobster-shrimp-chicken-quesadilla-combo");
		
		//Close popup location window
		locationPopupPage.getClosePopup().click();
		
		//Add to favorites
		mealPage.favoriteMeal();
		
		//Verify "Please login first!" message
		Thread.sleep(1000);
		String pleaseLoginMessage = mealPage.getPleaseLoginMessage().getText();
		System.out.println(pleaseLoginMessage);
		Assert.assertTrue(pleaseLoginMessage.contains("Please login first!"), "[ERROR] Unexpected error-Login message failed");
		
		//Navigate to new url
		driver.get(baseUrl + "guest-user/login-form");
		
		// II way of going to login page
//		WebElement loginBtn = driver.findElement(By.xpath("//li[@class='filled']/a"));
//		loginBtn.click();
		
		//Login with valid credentials
		loginPage.userLogin(email, password);
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".system_message"))));
		
		//Add to favorites
		mealPage.favoriteMeal();

		//Verify "Product has been added to your favorites" message
		Thread.sleep(2000);
		String mealAddedToFavorites = mealPage.getMealAddedToCartMessage().getText();
		System.out.println(mealAddedToFavorites);
		Assert.assertTrue(mealAddedToFavorites.contains("Product has been added to your favorites"), "[ERROR] Unexpected error-Product added message failed");
		
	}
	
	
	@Test(priority=0) 
	public void clearCart() throws IOException, InterruptedException {
		
		// Working with excel file
		File file = new File("./data/data.xlsx");
		
		FileInputStream fis = new FileInputStream(file);
		
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		
		XSSFSheet sheet = wb.getSheetAt(1);
		
		driver.get(baseUrl + "meals");
		
		SoftAssert softAssert = new SoftAssert();
	
		//Setup "City Center - Albany" location
		locationPopupPage.selectLocation("City Center - Albany");
		
		// Adding products and quantity to cart
		for(int i = 1; i < 6; i++) {
			String mealUrl = sheet.getRow(i).getCell(0).getStringCellValue();
			int quantity = (int) sheet.getRow(i).getCell(1).getNumericCellValue();
			
			Thread.sleep(1000);
			driver.get(mealUrl);
			
			Thread.sleep(1000);
			mealPage.addToCart(quantity);
			
			Thread.sleep(2000);
			String confirmationMessage = mealPage.getMealAddedToCartMessage().getText();
			System.out.println(confirmationMessage);
			softAssert.assertTrue(confirmationMessage.contains("Meal Added To Cart"), "[ERROR] Unexpected error-Meal added message failed");
			
		}
		
		//Verify with soft assert
		softAssert.assertAll();
		
		//Clearing cart
		cartSummaryPage.clearAll();
		
		//Verify "All meals removed from Cart successfully" message
		Thread.sleep(1000);
		String removeMessage = mealPage.getAllMealsRemovedMessage().getText();
		System.out.println(removeMessage);
		Assert.assertTrue(removeMessage.contains("All meals removed from Cart successfully"), "[ERROR] Unexpected error-Remove all meals failed");
			
	}
	
	
}
