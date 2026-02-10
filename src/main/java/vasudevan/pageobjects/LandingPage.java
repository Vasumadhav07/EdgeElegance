package vasudevan.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vasudevan.AbstractComponents.ReusableCodes;



public class LandingPage extends ReusableCodes{
	//WebDriver driver;
	public LandingPage(WebDriver driver) {
		
		super(driver);
//		this.driver=driver;
//		PageFactory.initElements(driver, this);
	}
	
	 @FindBy(css="button.js-cookie-consent-agree")
	 WebElement cookiesBtn;
	
    @FindBy(xpath="//a[@title='Login']")
    WebElement loginBtn;
    
    @FindBy(xpath="//input[@placeholder='Email address']")
    WebElement userEmail;
    
    @FindBy(css="#password")
    WebElement userPassword;
    
    @FindBy(css=".tptrack__submition")
    WebElement submitBtn;
    
	@FindBy(xpath="//a[contains(text(),'Shop')]")
	WebElement shopBtn;
	
    @FindBy(xpath="//div[@class='toast-message']")
    WebElement errorMessage;
	
    // Action methods to login 
    
    public void launchingURL() {
    	  driver.get("https://edgeelegance.in/");
    }
    
    public void loginActions() throws InterruptedException {
    	cookiesBtn.click();
    	loginBtn.click();
    }
 
 
 
    
    public ProductPage clickLoginBtn(String email , String password) throws InterruptedException {
    	scrollBy();
    	userEmail.sendKeys(email);
        userPassword.sendKeys(password);
    	waitForElementToBeClickable(submitBtn);
        submitBtn.click();
        waitForElementToBeClickable(shopBtn);
        shopBtn.click();
        ProductPage productPage = new ProductPage(driver);
        return productPage;

    }
    
//    public ProductPage shopPage() {
//    	 waitForElementToBeClickable(shopBtn);
//         shopBtn.click();
//         ProductPage productPage = new ProductPage(driver);
//         return productPage;
//    }
    
    public String errorValidations() {
    	waitForElementToAppear(errorMessage);
    	return errorMessage.getText();
    	
    }
    
    
    


    
    

}
