package tests;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LocationPopupPage;
import pages.ProfilePage;

public class ProfileTest extends BaseTest {

	private BaseTest baseTest;
	
	 //EDIT PROFILE TEST COMPLETED!
	@Test
	public void editProfile() throws InterruptedException {
		//Landing page
		driver.get(baseUrl + "guest-user/login-form");
		
		//Close popup location window
		locationPopupPage.closePopup();
		
		//Entering user credentials
		loginPage.userLogin(email, password);
		
		////Verify that login is successfull
		String loginSuccessMessage = loginPage.getLoginSuccessfullMessage().getText();
		System.out.println(loginSuccessMessage);
		Assert.assertTrue(loginSuccessMessage.contains("Login Successful"), "[ERROR] Unexpected error-Login failed");
		
		//Navigate to new url
		driver.navigate().to("http://demo.yo-meals.com/member/profile");
		
		//Updating profile data
		profilePage.updateProfileInfo("William", "Williamson", "K street", "0900 331332", "90210", "United Arab Emirates", "Dubai", "Deira");
		
		// Verify "Setup Successful" message
		Thread.sleep(1000);
		String setupSuccessfulMessage = profilePage.getSetupSuccessfulMessage().getText();
		System.out.println(setupSuccessfulMessage);
		Assert.assertTrue(setupSuccessfulMessage.contains("Setup Successful"), "[ERROR] Unexpected error-Setup failed");
		
		//Logout from application
		authPage.getUserNameBtn().click();
		Thread.sleep(3000);
		authPage.getLogoutBtn().click();
		
		//Verify "Logout Successfull" message
		String logoutSuccessfullMessage = loginPage.getLogoutSuccessfullMessage().getText();
		System.out.println(logoutSuccessfullMessage);
		Assert.assertTrue(logoutSuccessfullMessage.contains("Logout Successfull"), "[ERROR] Unexpected error-Logout failed");
	}
	
	@Test
	public void changeProfileImage() throws IOException, InterruptedException, AWTException {
		//Landing page
		driver.get(baseUrl + "guest-user/login-form");

		//Close popup location window
		locationPopupPage.closePopup();

		
		//Entering user credentials
		loginPage.userLogin(email, password);

		//Verify that login is successfull
		String loginSuccessMessage = loginPage.getLoginSuccessfullMessage().getText();
		System.out.println(loginSuccessMessage);
		Assert.assertTrue(loginSuccessMessage.contains("Login Successful"), "[ERROR] Unexpected error-Login failed");
		
		//Navigate to new url
		driver.get(baseUrl + "member/profile");

		//Moving to desired web element
		Thread.sleep(3000);
		Actions action = new Actions(driver);
		action.moveToElement(profilePage.getAvatar()).build().perform();
				
		Thread.sleep(2000);

		//Uploading profile image
		profilePage.uploadImg();

		//Verify "Profile Image Uploaded Successfully" message
		Thread.sleep(2000);
		String profileImageUploadedSuccessfully = profilePage.getImgUploadedSuccess().getText();
		System.out.println(profileImageUploadedSuccessfully);
		Assert.assertTrue(profileImageUploadedSuccessfully.contains("Profile Image Uploaded Successfully"), "[ERROR] Unexpected error-Upload failed");

		//Removing profile image
		Thread.sleep(3000);
		profilePage.removeImg();

		//Verify message "Profile Image Deleted Successfully"
		Thread.sleep(2000);
				
		String profileImageDeletedSuccessfully = driver.findElement(By.xpath("//div[@class='content']")).getText();
		System.out.println(profileImageDeletedSuccessfully);
		Assert.assertTrue(profileImageDeletedSuccessfully.contains("Profile Image Deleted Successfully"), "[ERROR] Unexpected error-Delete failed");

		//Logout from application
		authPage.getUserNameBtn().click();
		Thread.sleep(3000);
		authPage.getLogoutBtn().click();
				
		//Verify "Logout Successfull" message
		String logoutSuccessfullMessage = loginPage.getLogoutSuccessfullMessage().getText();
		Thread.sleep(1000);
		System.out.println(logoutSuccessfullMessage);
		Assert.assertTrue(logoutSuccessfullMessage.contains("Logout Successfull"), "[ERROR] Unexpected error-Logout failed");

		
	}
	
}
