package commons;

import java.time.Duration;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class BaseTest {
	private WebDriver driver;
	
	protected WebDriver  getBrowserDriver(String browserName) {
		BrowserList browser = BrowserList.valueOf(browserName.toUpperCase());
		if (browser == BrowserList.FIREFOX) {
			//driver = WebDriverManager.firefoxdriver().create();
			driver = new FirefoxDriver();
		} 
		else if (browser == BrowserList.CHROME) {
			//driver = WebDriverManager.chromedriver().create();
			driver = new ChromeDriver();
		} 
		else if (browser == BrowserList.EDGE) {
			//driver = WebDriverManager.edgedriver().create();
			driver = new EdgeDriver();
		}else {
			throw new RuntimeException("Browser name is not valid");
		}
		
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		return driver;
	}
	
	protected void quitBrowserDriver () {
		if (driver != null) {
			driver.quit();
		}
	}
	
	protected String getEmailAddress() {
		Random rand = new Random();
		return "john" + rand.nextInt(9999) + "@gmail.com";
	}
}
