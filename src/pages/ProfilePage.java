package pages;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class ProfilePage extends BasePage{
	
	public ProfilePage(WebDriver driver, JavascriptExecutor js) {
		super(driver, js);
	}

	public WebElement getFirstName() {
		return driver.findElement(By.xpath("//*[@name='user_first_name']"));
	}
	
	public WebElement getLastName() {
		return driver.findElement(By.xpath("//*[@name='user_last_name']"));
	}
	
	public WebElement getAddress() {
		return driver.findElement(By.xpath("//*[@name='user_address']"));
	}
	
	public WebElement getPhoneNo() {
		return driver.findElement(By.xpath("//*[@name='user_phone']"));
	}
	
	public WebElement getZipCode() {
		return driver.findElement(By.xpath("//*[@name='user_zip']"));
	}
	
	public WebElement getCountry() { // select dropdown
		return driver.findElement(By.xpath("//*[@name='user_country_id']"));
	}
	
	public WebElement getState() { // select dropdown
		return driver.findElement(By.xpath("//*[@name='user_state_id']"));
	}
	
	public WebElement getCity() { // select dropdown
		return driver.findElement(By.xpath("//*[@name='user_city']"));
	}
	
	public WebElement getAvatar() {
		return driver.findElement(By.xpath("//div[@class='avatar']"));
	}
	
	public WebElement getUploadImgBtn() {
		return driver.findElement(By.xpath("//div[@class='hover-elemnts']/a"));
	}
	
	public WebElement getImgUploadedSuccess() {
		return driver.findElement(By.xpath("//div[@class='content']"));
	}
	
	public WebElement getFormBtn() {
		return driver.findElement(By.xpath("//input[@type = 'file']"));
	}
	
	public WebElement getRemoveImgBtn() {
		return driver.findElement(By.xpath("//div[@class='hover-elemnts']/a[2]"));
	}
	
	public WebElement getSetupSuccessfulMessage() {
		return driver.findElement(By.xpath("//div[@class='content']"));
	}
	
	public WebElement getSaveBtn() {
		return driver.findElement(By.xpath("(//input[@name='btn_submit'])[1]"));
	}
//	da bi se na stranici pojavio element input type="file" potrebno je da se prvo izvrši JavaScript kod koji vrši akciju klik na Upload dugme 
//			Skripta: arguments[0].click();
	public void uploadImg() throws IOException {
		js.executeScript("arguments[0].click()", this.getUploadImgBtn());

		String imgPath = new File("img\\images.jpg").getCanonicalPath();
		driver.findElement(By.xpath("//input[@type='file']")).sendKeys(imgPath);
	}


	
	public void removeImg() {
		js.executeScript("arguments[0].click();", this.getRemoveImgBtn());
		
	}


	
	// COMPLETED
	public void updateProfileInfo(String firstName, String lastName, String address, String phoneNo, String zipCode, String selectCountry, String selectState, String selectCity) throws InterruptedException {
		this.getFirstName().clear();
		this.getFirstName().sendKeys(firstName);
		this.getLastName().clear();
		this.getLastName().sendKeys(lastName);
		this.getAddress().clear();
		this.getAddress().sendKeys(address);
		this.getPhoneNo().clear();
		this.getPhoneNo().sendKeys(phoneNo);
		this.getZipCode().clear();
		this.getZipCode().sendKeys(zipCode);
		
		Select country = new Select(this.getCountry());
		country.selectByVisibleText(selectCountry);
		Thread.sleep(500);
		
		Select state = new Select(this.getState());
		state.selectByVisibleText(selectState);
		Thread.sleep(500);
		
		Select city = new Select(this.getCity());
		city.selectByVisibleText(selectCity);
		Thread.sleep(500);
		
		this.getSaveBtn().click();
		
		
	}
	

}
