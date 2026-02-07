package vasudevan.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
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

	
	}
	
	


