package vasu.vasudevan;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EdgeElegance_EndToEnd {
    public static void main(String[] args) throws InterruptedException {

        String productName = "Pink Sequinned Ready to Wear Lehenga Blouse With Dupatta Potli Bag";

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        driver.get("https://edgeelegance.in/");
        driver.findElement(By.xpath("//button[contains(text(),'cookies')]")).click();
       // LandingPage landingPage = new LandingPage(driver);
        driver.findElement(By.xpath("//a[@title='Login']")).click();

        js.executeScript("window.scrollBy(0,500)");
        Thread.sleep(2000);

        driver.findElement(By.xpath("//input[@placeholder='Email address']")).sendKeys("amansignh99@gmail.com");
        driver.findElement(By.cssSelector("#password")).sendKeys("Vasu@123");
        driver.findElement(By.cssSelector(".tptrack__submition")).click();

        driver.findElement(By.xpath("//a[contains(text(),'Shop')]")).click();
        Thread.sleep(1000);

        // Find product
        List<WebElement> products = driver.findElements(By.cssSelector("h3 a"));
        WebElement prod = products.stream()
                .filter(p -> p.getText().trim().equals(productName))
                .findFirst()
                .orElse(null);

         prod.click();

        // Wait for Add to Cart
         Thread.sleep(1000);
         js.executeScript("window.scrollBy(0,500)");
         Thread.sleep(1000);
         //wait.until( ExpectedConditions.elementToBeClickable(By.cssSelector(".btn.add-to-cart")));


         driver.findElement(By.xpath("//button[@class='btn add-to-cart']")).click();
        //wait.until( ExpectedConditions.elementToBeClickable(By.cssSelector(".btn.add-to-cart")));

        //js.executeScript("arguments[0].scrollIntoView(true);", cart);
        //cart.click();

        // Wait for Checkout button
        WebElement checkoutBtn = wait.until(
                ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='tpcheck-btn']"))
        );

        js.executeScript("arguments[0].scrollIntoView(true);", checkoutBtn);
        checkoutBtn.click();

        // Now scroll on the checkout page
        
        js.executeScript("window.scrollBy(0,2000)");
        Thread.sleep(1000);        
       driver.findElement(By.cssSelector("#checkout-btn")).click(); 
       Thread.sleep(300);
       driver.navigate().refresh();
       driver.findElement(By.xpath("//a[@title='Login']")).click();
       Thread.sleep(1000);
       js.executeScript("window.scrollBy(0,300)");
       Thread.sleep(1000);
       driver.findElement(By.xpath("//a[text()='Orders']")).click();
       List<WebElement> links = driver.findElements(By.cssSelector("td a"));
       WebElement firstLink = links.get(0);
       firstLink.click();
       
       String confirm =driver.findElement(By.cssSelector(".customer-page-title")).getText();
      // System.out.println(confirm);
       Assert.assertEquals(confirm, "Order information");
       driver.close();
       
       
    
//       WebElement invoice =driver.findElement(By.xpath("//div//a[contains(text(),'Download')]"));
//       js.executeScript("arguments[0].scrollIntoView(true);", invoice);
//       invoice.click();

       

    }
    
} 

