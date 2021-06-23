package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public abstract class BasePage {
protected WebDriver driver;
protected JavascriptExecutor js;
	
	public BasePage(WebDriver driver, JavascriptExecutor js) {
		this.driver = driver;
		this.js = js;
		
	}

}
