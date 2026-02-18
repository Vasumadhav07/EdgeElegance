package vasudevan.TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

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
	
	public List<HashMap<String, String>> getData(String FilePath) throws IOException {
		
		 String content =FileUtils.readFileToString(new File(System.getProperty("user.dir")+"\\src\\test\\java\\vasudevan\\Data\\userData.json"),StandardCharsets.UTF_8);
		 ObjectMapper mapper = new ObjectMapper();
		 List<HashMap<String, String>> data =
				    mapper.readValue(content,
				        new TypeReference<List<HashMap<String, String>>>() {});
		 
		              return data;

		 
		 
	}
	
	
    @AfterTest
    public void closeApp() {
  	   driver.close();
   }

	
	

}
