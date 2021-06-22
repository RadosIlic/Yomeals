package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NotificationSystemPage extends BasePage {

	public NotificationSystemPage(WebDriver driver, JavascriptExecutor js) {
		super(driver, js);
	}

	public WebElement getMessage() {
		return driver.findElement(By.xpath("//*[contains(@class, 'alert--success') or contains(@class, 'alert--danger')][contains(@style,'display: block')]"));
	}
	
	public void textMessage() {
		System.out.println(this.getMessage().getText());
	}
	
	public void textMessageDisappear() { 
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.attributeToBe(driver.findElement(By.xpath("//*[contains(@class, 'system_message')]")), "style", "display: none;"));
	}

	
	
}
