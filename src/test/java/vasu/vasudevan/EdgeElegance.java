package vasu.vasudevan;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        LandingPage landingPage = new LandingPage(driver);
        landingPage.launchingURL();
        landingPage.loginActions();
        landingPage.clickLoginBtn("amansignh99@gmail.com", "Vasu@123");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Shop')]")));
        driver.findElement(By.xpath("//a[contains(text(),'Shop')]")).click();
        ProductPage productPage = new ProductPage(driver);
        productPage.getProductList();
        productPage.getProduct(productName);
        productPage.addToCart();
        CartPage cartPage = new CartPage(driver);
        cartPage.cartPageActions();
        Thread.sleep(300);
        driver.navigate().refresh();
        OrderPage orderPage= new OrderPage(driver);
        orderPage.viewOrder();
        
        
       

    }
    
} 

