package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage{

	//Page constructor
	public LoginPage(WebDriver driver, JavascriptExecutor js) {
		super(driver, js);
	}
	
	String route = "guest-user/login-form";
	
	// Web elements needed for login
	public WebElement getEmail() {
		return driver.findElement(By.xpath("//*[@name='username']"));
	}
	
	public WebElement getPassword() {
		return driver.findElement(By.xpath("//*[@name='password']"));
	}
	
	public WebElement getRememberMe() {
		return driver.findElement(By.xpath("//*[@name='remember_me']"));
	}
	
	public WebElement getLoginBtn() {
		return driver.findElement(By.xpath("//*[@value='Login']"));
	}
	
	public WebElement getLoginSuccessfullMessage() {
		return driver.findElement(By.xpath("//div[@class='div_msg']/ul/li"));
	}
	
	public WebElement getLogoutSuccessfullMessage() {
		return driver.findElement(By.xpath("//div[@class='div_msg']/ul/li"));
	}
	
	//User login method 
	
	public void userLogin(String email, String password) {
		this.getEmail().clear();
		this.getPassword().clear();
		
		this.getEmail().sendKeys(email);
		this.getPassword().sendKeys(password);
		
		this.getRememberMe().click();
		
		this.getLoginBtn().click();
		
	}
	

}
