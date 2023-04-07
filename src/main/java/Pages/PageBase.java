package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class PageBase {
	
	public int timeOut = 30;

	
	WebDriver driver;

	public PageBase(WebDriver driver) {
		this.driver=driver;
	}
	
	protected WebElement getElement(By by){
		return driver.findElement(by);
	}

	protected void clickButton(WebElement element){
		waitUntilVisible(element);
		element.click();
	}
	public boolean waitUntilElementClickableAndClick(WebElement element){
		// Wait for Element to be visible.
		try {
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeOut));
			element = wait.until(ExpectedConditions.elementToBeClickable(element));
			element.click();
			return true;
		} catch (Exception e) {
			// Element not found, return false
			e.printStackTrace();
			return false;
		}

	}
	// Method to send Keys
	protected  void clearAndSetText(WebElement element, String value) {
		waitUntilVisible(element);
		element.clear();
		element.sendKeys(value);
	}

	protected  void setText(WebElement element, String value) {
		waitUntilVisible(element);
		element.sendKeys(value);
	}
 
	public  boolean waitUntilVisible(WebElement element){
		// Wait for Element to be visible.
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
			wait.until(ExpectedConditions.visibilityOf(element));
			// element found, return true
			return true;
		} catch (Exception e) {
			// Element not found, return false
			e.printStackTrace();
			return false;
		}

	}
	

	public  boolean isElementAppear(WebElement element){
		// Wait for Element to be visible.
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
			wait.until(ExpectedConditions.visibilityOf(element));
			return true;
		} catch (Exception e) {
			// Element not found, return false
			return false;
		}

	}

	public  boolean isElementNotExist(By element){
		
		return driver.findElements(element).size() == 0;

	}


	
}
