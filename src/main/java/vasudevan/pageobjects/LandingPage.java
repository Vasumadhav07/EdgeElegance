package vasudevan.pageobjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vasudevan.AbstractComponents.ReusableCodes;



public class LandingPage extends ReusableCodes{
	WebDriver driver;
	public LandingPage(WebDriver driver) {
		
		super(driver);
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
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
    
    // Action methods to login 
    
    public void launchingURL() {
    	  driver.get("https://edgeelegance.in/");
    }
    
    public void loginActions() throws InterruptedException {
    	cookiesBtn.click();
    	loginBtn.click();
    }
 

 
    
    public void clickLoginBtn(String email , String password) throws InterruptedException {
    	scrollBy();
    	userEmail.sendKeys(email);
        userPassword.sendKeys(password);
    	waitForElementToBeClickable(submitBtn);
        submitBtn.click();

    }
    
    
    


    
    

}
