package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartSummaryPage extends BasePage {
	
	public CartSummaryPage(WebDriver driver, JavascriptExecutor js) {
		super(driver, js);
	}

	public WebElement getClearAllBtn() {
		return driver.findElement(By.xpath("//div[@class='cart-head']/a[2]"));
	}
	
	public WebElement getMealAddedToCart() {
		return driver.findElement(By.xpath("//div[@class='content']"));
	}
	
	public WebElement getMealRemovedFromCart() {
		return driver.findElement(By.xpath("//div[@class='content']"));
	}
	
	public void clearAll() {
		this.getClearAllBtn().click();
	}
	
	

}
