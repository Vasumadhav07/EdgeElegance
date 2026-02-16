package vasudevan.pageobjects;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import vasudevan.AbstractComponents.ReusableCodes;

public class OrderPage extends ReusableCodes{
	//WebDriver driver;
	public OrderPage(WebDriver driver) {
		super(driver);
		//this.driver = driver;
		//PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//a[@title='Login']")
	WebElement logiBtn;
	//   driver.findElement(By.xpath("//a[text()='Orders']")).click();
	@FindBy(xpath="//a[text()='Orders']")
	WebElement orderBtn;

	@FindBy(css="td a")
	List<WebElement> orderList;
	
	//By.cssSelector(".customer-page-title")).getText();
	@FindBy(css=".customer-page-title")
    WebElement confirmMesage;
	
	@FindBy(xpath="//a[@href='https://edgeelegance.in/customer/orders/print/306']")
	WebElement downloadInvoice;
	
	public void viewOrder() throws InterruptedException {
		logiBtn.click();
		scrollBy();
		orderBtn.click();
		WebElement takingOrder =orderList.get(0);
		takingOrder.click();
		confirmMesage.getText().trim();
		waitForElementToAppear(confirmMesage);
		
	}
	public String getOrderConfirmationText() {
	    return confirmMesage.getText().trim();
	  
	}
	
	public void invoiceDownload() throws InterruptedException {
		//driver.navigate().refresh();
		logiBtn.click();
		scrollBy();
		orderBtn.click();
		WebElement takingOrder =orderList.get(0);
		takingOrder.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,900)");
		waitForElementToAppear(downloadInvoice);
		downloadInvoice.click();
		
		
	}

	
	}
	
	


