package vasu.vasudevan;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;
import vasudevan.pageobjects.CartPage;
import vasudevan.pageobjects.LandingPage;
import vasudevan.pageobjects.OrderPage;
import vasudevan.pageobjects.ProductPage;

public class EdgeElegance   {
    public static void main(String[] args) throws InterruptedException {

        String productName = "Embellished Thread Work Lehenga & Blouse With Dupatta";
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        LandingPage landingPage = new LandingPage(driver);
        landingPage.launchingURL();
        landingPage.loginActions();
        ProductPage productPage =  landingPage.clickLoginBtn("amansignh99@gmail.com", "Vasu@123");
        productPage.getProduct(productName);
        CartPage cartPage = productPage.addToCart();
        cartPage.cartPageActions();
        driver.navigate().refresh();
        OrderPage orderPage= new OrderPage(driver);
        orderPage.viewOrder();
        String actualText = orderPage.getOrderConfirmationText();
        String expectedText = "Order information";
        Assert.assertEquals(actualText, expectedText);
        driver.close();
        
        
       

    }
    
} 

