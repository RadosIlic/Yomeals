package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchResultPage extends BasePage {

	public SearchResultPage(WebDriver driver, JavascriptExecutor js) {
		super(driver, js);
	}
	
	public List<WebElement> getSearchResults() {
		return driver.findElements(By.xpath("//*[@class='product-name']/a"));
	}
	
	public void totalSearchResult() {
		int searchResultCount = this.getSearchResults().size();
	}
	
	

}
