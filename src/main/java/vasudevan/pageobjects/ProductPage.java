package vasudevan.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import vasudevan.AbstractComponents.ReusableCodes;



public class ProductPage extends ReusableCodes {
   // WebDriver driver;
	public ProductPage(WebDriver driver) {
		super(driver);
//		 this.driver = driver;
//		 PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="h3 a")
	List<WebElement>products;
	
	@FindBy(css="h3 a")
	List<WebElement>productlist;
	
	@FindBy(xpath="//button[@class='btn add-to-cart']")
	WebElement clickAddToCart;
	
	
	public List<WebElement> getProductList() {
		
		waitForElementsToAppear(productlist);
		return products;
	}
	
	public WebElement getProduct(String productName) {
		WebElement prod = getProductList().stream().filter(p -> p.getText().trim().equals(productName)).findFirst().orElse(null);
		prod.click();
	    return prod;

	}
	
	public CartPage addToCart() throws InterruptedException  {
		 scrollBy();
         waitForElementToAppear(clickAddToCart);
         clickAddToCart.click();
         CartPage cartPage = new CartPage(driver);
         return cartPage;
	}
	

    
    

}
