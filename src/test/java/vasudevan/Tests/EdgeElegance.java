  
package vasudevan.Tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import vasudevan.TestComponents.BrowserTestComponents;
import vasudevan.pageobjects.CartPage;
import vasudevan.pageobjects.LandingPage;
import vasudevan.pageobjects.OrderPage;
import vasudevan.pageobjects.ProductPage;

public class EdgeElegance  extends  BrowserTestComponents {
	 String productName = "Embellished Thread Work Lehenga & Blouse With Dupatta";
     @Test
      public void submitOrder() throws IOException, InterruptedException  {
   
        LandingPage landingPage;
    	landingPage= launchApplication();
    	landingPage.loginActions();
        ProductPage productPage =  landingPage.clickLoginBtn("amansignh99@gmail.com", "Vasu@123");
        productPage.getProduct(productName);
        CartPage cartPage = productPage.addToCart();
        cartPage.cartPageActions();
        OrderPage orderPage= new OrderPage(driver);
        orderPage.viewOrder();
        String actualText = orderPage.getOrderConfirmationText();
        String expectedText = "Order information";
        Assert.assertEquals(actualText, expectedText);
     
      }   
     @AfterTest
      public void closeApp() {
    	   driver.close(); 
     }

    
    
} 

