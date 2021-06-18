package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LocationPopupPage extends BasePage {
	
	//Page constructor 
	public LocationPopupPage(WebDriver driver) {
		super(driver);
	}

	// Web elements for closing and opening popup location window
	
	public WebElement getClosePopup() {
		return driver.findElement(By.xpath("//div[@class='model-box-mid location-search']/a"));
	}
	
	public WebElement getLocation() {
		return driver.findElement(By.xpath("//div[@class='location-selector']/a"));
	}
	
	//Web elements needed for method implementation for select location
	
	public WebElement getKeyword() {
		return driver.findElement(By.id("locality_keyword"));
	}
	
	public WebElement getLocationItem(String locationName) {
		return driver.findElement(By.xpath("//li/a[contains(text(), '" + locationName + "')]/.."));
	}
	
	public WebElement getLocationInput() {
		return driver.findElement(By.xpath("//*[@id='location_id']"));
	}
	
	public WebElement getSubmit() {
		return driver.findElement(By.xpath("//*[@name='btn_submit']"));
	}
	
//	Open popup method
	
	public void openPopupLocation() {
		this.getLocation().click();
	}
	
//	Select location method
	
	public void selectLocation(String locationName) {
		this.getKeyword().click();
		String dataValue = this.getLocationItem("Delaware Avenue - Albany").getAttribute("data-value");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value=arguments[1];", this.getLocationInput(), dataValue);
		js.executeScript("arguments[0].click();", this.getSubmit());
	}
	
	//Close popup method
	public void closePopup() {
		this.getClosePopup().click();
	}

}
