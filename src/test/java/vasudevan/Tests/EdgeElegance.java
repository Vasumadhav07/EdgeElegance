  
package vasudevan.Tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import vasudevan.TestComponents.BrowserTestComponents;
import vasudevan.pageobjects.CartPage;
import vasudevan.pageobjects.OrderPage;
import vasudevan.pageobjects.ProductPage;

public class EdgeElegance  extends  BrowserTestComponents {
	 String productName = "Pink Sequinned Ready to Wear Lehenga Blouse With Dupatta Potli Bag";    
	 
     @Test(dataProvider="userData")
        public void submitOrder(HashMap<String , String> input)throws IOException, InterruptedException  {
    	landingPage= launchApplication();
    	landingPage.loginActions();
    	ProductPage productPage = landingPage.clickLoginBtn(input.get("email"),input.get("password"));
    	productPage.getProduct(input.get("product"));
        CartPage cartPage = productPage.addToCart();
        cartPage.cartPageActions();
        OrderPage orderPage= new OrderPage(driver);
        orderPage.viewOrder();
        String actualText = orderPage.getOrderConfirmationText();
        String expectedText = "Order information";
        Assert.assertEquals(actualText, expectedText);
     
      }   
     
//     @Test(dependsOnMethods= {"submitOrder"})
//     
//     public void verifyOrder() throws InterruptedException {
//    	 
//         OrderPage orderPage= new OrderPage(driver);
//         orderPage.invoiceDownload();
//                 
//     }
     
     @DataProvider
     
     public Object[][] userData() throws IOException {
    	 List<HashMap<String, String>> data =
    			    getData(
    			        System.getProperty("user.dir")
    			        + "\\src\\test\\java\\vasudevan\\Data\\userData.json"
    			    );

    	 return new Object[][] {{data.get(0)}, {data.get(1)} };
     }
//     
     
 
    
    
} 

