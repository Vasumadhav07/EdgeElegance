  
package vasudevan.Tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import vasudevan.TestComponents.BrowserTestComponents;
import vasudevan.pageobjects.CartPage;
import vasudevan.pageobjects.ProductPage;

public class ErrorValidations  extends  BrowserTestComponents {
	 String productName = "Embellished Thread Work Lehenga & Blouse With Dupatta";
     @Test
        public void loginValidations() throws IOException, InterruptedException  {
        
         	landingPage= launchApplication();
         	landingPage.loginActions();
         	ProductPage productPage = landingPage.clickLoginBtn("amansignh99@gmail.com", "Vasu@123");
            Assert.assertEquals("These credentials do not match our records.", landingPage.errorValidations()); 
 

     
      }  
     @Test
     public void ProductErrorvlidations() throws IOException, InterruptedException  {
    	 landingPage= launchApplication();
     	landingPage.loginActions();
     	ProductPage productPage = landingPage.clickLoginBtn("amansignh99@gmail.com", "Vasu@123");
     	Assert.assertEquals("dress",productPage .getProduct(productName));
        CartPage cartPage = productPage.addToCart();
        cartPage.cartPageActions();
    
    
} 
 
}

