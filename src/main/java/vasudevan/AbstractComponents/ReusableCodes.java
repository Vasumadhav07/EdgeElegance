package vasudevan.AbstractComponents;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReusableCodes {
	WebDriver driver;

	public ReusableCodes(WebDriver driver) {
		this .driver=driver;
		PageFactory.initElements(driver, this); 	 	
	}
	
	public void waitForElementToBeClickable(WebElement element) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	
	public void waitForElementToAppear(WebElement element) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public List<WebElement> waitForElementsToAppear(List<WebElement> elements) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfAllElements(elements));
        return elements;
	}
	
	
	   public void scrollBy() throws InterruptedException {
		    JavascriptExecutor js = (JavascriptExecutor) driver;
		    Thread.sleep(2000);
		    js.executeScript("window.scrollBy(0,400)");
		    Thread.sleep(2000);
		   
		}
	  
 
	   
	  

		   
	

}
