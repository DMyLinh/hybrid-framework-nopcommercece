package pageFactory;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePageFactory {
	public void openUrl(WebDriver driver, String url) {
		driver.get(url);
	}
	
	public String getPageTitle (WebDriver driver) {
		return driver.getTitle();
	}
	
	public String getPageUrl (WebDriver driver) {
		return driver.getCurrentUrl();
	}
	
	public String getPageSource (WebDriver driver) {
		return driver.getPageSource();
	}
	
	public void backToPage (WebDriver driver) {
		driver.navigate().back();
	}
	
	public void refreshCurrentPage (WebDriver driver) {
		driver.navigate().refresh();
	}
	
	public void forwardToPage (WebDriver driver) {
		driver.navigate().forward();
	}
	
	public void acceptToAlert (WebDriver driver) {
		waitForAlertPresence(driver).accept();
	}
	
	public void cancelToAlert (WebDriver driver) {
		waitForAlertPresence(driver).dismiss();
	}
	
	public String getAlertText (WebDriver driver) {
		return waitForAlertPresence(driver).getText();
	}
	
	public void sendKeyToAlert(WebDriver driver, String valueToSendKey) {
		driver.switchTo().alert().sendKeys(valueToSendKey);
	}
	
	public Alert waitForAlertPresence(WebDriver driver) {
		//return new WebDriverWait(driver, 30).until(ExpectedConditions.alertIsPresent());
		return new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.alertIsPresent());
	}
	
	public void switchToWindowByID(WebDriver driver, String windowID) {
		Set<String> allIDs = driver.getWindowHandles();
		for (String id : allIDs) {
				if(!id.equals(windowID)) {
					driver.switchTo().window(id);
					break;
				}
			}
		}
		
	public void switchToWindowByTitle(WebDriver driver, String expectedTitle) {
		Set<String> allIDs = driver.getWindowHandles();
		for (String id : allIDs) {
				driver.switchTo().window(id);
				String actualTitle = driver.getTitle();
				if(actualTitle.equals(expectedTitle)) {
					break;
				}			
			}		
		}
		
	public void closeAllWindowsWithoutExpectedID (WebDriver driver, String expectedID) {
		Set<String> allIDs = driver.getWindowHandles();
		for (String id : allIDs) {
				if (!id.equals(expectedID)) {
					driver.switchTo().window(id);
					driver.close();
				}
			}
			driver.switchTo().window(expectedID);
		}
		
	public void sleepInSecond(long timoutInSecond) {
		try {
				Thread.sleep(timoutInSecond * 1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	public void clickToElement(WebDriver driver, WebElement element) {
		element.click();
	}

	public String getElementAttribute(WebDriver driver, WebElement element, String attributeName) {
		return element.getAttribute(attributeName);
	}
	
	public void sendkeyToElement(WebDriver driver, WebElement element, String value) {
		element.clear();
		element.sendKeys(value);
	}

	public String getElementText(WebDriver driver, WebElement element) {
		return element.getText();
	}
	
	public void waitForElementVisible(WebDriver driver, WebElement element) {
		new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOf(element));
	}

	public void waitForElementClickable(WebDriver driver, WebElement element) {
		new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(element));
	}
}
