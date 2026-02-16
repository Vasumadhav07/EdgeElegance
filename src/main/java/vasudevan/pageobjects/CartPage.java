package vasudevan.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import vasudevan.AbstractComponents.ReusableCodes;

public class CartPage extends ReusableCodes {
	
	//WebDriver driver;
	public CartPage(WebDriver driver) {
		super(driver);
//		this.driver=driver;
//		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@class='tpcart-btn mb-10']")
	WebElement cartBtn;
	
	@FindBy(xpath="//a[text()='Proceed to Checkout']")
	WebElement proceedToCheckoutBtn;
	
	@FindBy(css="#checkout-btn")
	WebElement checkoutBtn;
	
	
	public void cartPageActions() throws InterruptedException {
		Thread.sleep(1000);
		cartBtn.click();
		scrollBy() ;
		proceedToCheckoutBtn.click();
		scrollBy() ;
		checkoutBtn.click();
		Thread.sleep(300);
		driver.navigate().refresh();
	
		
	}
	

}
