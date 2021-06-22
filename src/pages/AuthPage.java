package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AuthPage extends BasePage{

	
	public AuthPage(WebDriver driver, JavascriptExecutor js) {
		super(driver, js);
	}

	public WebElement getUserNameBtn() {
		return driver.findElement(By.xpath("//li[@class='filled ']/a"));
	}
	
	public WebElement getMyAccountBtn() {
		return driver.findElement(By.xpath(" //div[@class='my-account-dropdown']/ul/li[1]/a"));
		//driver.findElement(By.linkText("My Account"));
	}
	
	public WebElement getLogoutBtn() {
		return driver.findElement(By.xpath(" //div[@class='my-account-dropdown']/ul/li[2]/a"));
		//driver.findElement(By.linkText("Logout"));
	}

	
}
