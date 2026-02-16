package vasudevan.TestComponents;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import vasudevan.pageobjects.LandingPage;

public class BrowserTestComponents {
	// WebDriver driver;
	protected WebDriver driver;
	protected LandingPage landingPage;
	
	public WebDriver initiaizeBrowser() throws IOException {
		Properties property = new Properties();
		FileInputStream file = new FileInputStream((System.getProperty("user.dir")+"\\src\\main\\java\\vasudevan\\resources\\globaldata.properties"));
		property.load(file);
		String browserName =property.getProperty("browser");
		
		if(browserName.equalsIgnoreCase("chrome")) {
		WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
		}
		else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			 driver.manage().window().maximize();
			
		}
     
        return driver;
	}

	
	public LandingPage launchApplication() throws IOException {
		driver = initiaizeBrowser();
		landingPage = new LandingPage(driver);
		landingPage.launchingURL();
		return landingPage;
	}
	
    @AfterTest
    public void closeApp() {
  	   driver.close(); 
   }

	
	

}
