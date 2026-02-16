  
package vasudevan.Tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import vasudevan.TestComponents.BrowserTestComponents;
import vasudevan.pageobjects.CartPage;
import vasudevan.pageobjects.OrderPage;
import vasudevan.pageobjects.ProductPage;

public class EdgeElegance  extends  BrowserTestComponents {
	 String productName = "Pink Sequinned Ready to Wear Lehenga Blouse With Dupatta Potli Bag";    
	 
	 
	 
	 
     @Test
        public void submitOrder() throws IOException, InterruptedException  {
    	landingPage= launchApplication();
    	landingPage.loginActions();
    	ProductPage productPage = landingPage.clickLoginBtn("amansignh99@gmail.com", "Vasu@123");
    	productPage.getProduct(productName);
        CartPage cartPage = productPage.addToCart();
        cartPage.cartPageActions();
        OrderPage orderPage= new OrderPage(driver);
        orderPage.viewOrder();
        String actualText = orderPage.getOrderConfirmationText();
        String expectedText = "Order information";
        Assert.assertEquals(actualText, expectedText);
     
      }   
     
     @Test(dependsOnMethods= {"submitOrder"})
     
     public void verifyOrder() throws InterruptedException {
    	 
         OrderPage orderPage= new OrderPage(driver);
         orderPage.invoiceDownload();
         
         
         
         
         
     }
 
    
    
} 

