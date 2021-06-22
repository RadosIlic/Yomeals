package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MealPage extends BasePage {
	
	public MealPage(WebDriver driver, JavascriptExecutor js) {
		super(driver, js);	
	}
	
	// Needed Web Elements
	public WebElement getQuantity() {
		return driver.findElement(By.xpath("//input[@name='product_qty']"));
	}
	
	public WebElement getAddToCartBtn() {
		return driver.findElement(By.xpath("//div[@class='price-feature--wrapper']/div/a"));
	}
	
	public WebElement getErrorMesage() {
		return driver.findElement(By.xpath("//div[@class='div_error']"));
	}
	
	public WebElement getPleaseLoginMessage() {
		return driver.findElement(By.xpath("//div[@class='content']"));
	}
	
	public WebElement getMealAddedToCartMessage() {
		return driver.findElement(By.xpath("//div[@class='content']"));
	}
	
	public WebElement getAllMealsRemovedMessage() {
		return driver.findElement(By.xpath("//div[@class='content']"));
	}
	
	public WebElement getFavoriteBtn() {
		return driver.findElement(By.xpath("//div[@class='product-detail-image']/a"));
	}
	
	public WebElement getProductAddedToFavorites() {
		return driver.findElement(By.xpath("//div[@class='div_msg']/ul/li"));
	}
	
	//TEST METHOD za clearCart test
	public void addToCart(int quantity) {
		
		String stringQuantity = String.valueOf(quantity);
		this.getQuantity().click();
		this.getQuantity().sendKeys(Keys.BACK_SPACE);
		this.getQuantity().sendKeys(stringQuantity);
		this.getAddToCartBtn().click();
	}
	public void favoriteMeal() {
		this.getFavoriteBtn().click();
	}
}
