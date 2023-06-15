package commons;

import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	//	1 - Access Modifier: public/ protected/ private/ default
	
	//	2 - Kiểu dữ liệu của hàm (Data type): void/ int/ String/ boolean/ WebElement/ List<WebElement>/..
	//	Nó sẽ liên quan đến cái chức năng mình viết trong thân hàm
	
	//	3 - Tên hàm: Đặt tên có nghĩa theo chức năng đang cần viết
	//	Convention tuân theo chuẩn của từng ngôn ngữ lập trình (Java)
	//	camelCase: từ đầu tiên viết thường - chữ cái đầu tiên của các từ tiếp theo sẽ viết hoa
	
	//	4 - Có tham số hay ko (tùy vào chức năng cần viết)
	//  Dựa vào hàm của selenium mình gọi ra để dùng là gì
	//	Web Browser: WebDriver driver
	// 	Web Element: WebDriver driver, String locator
	
	//	5 - Kiểu dữ liệu trả về cho hàm
	//	Nếu như có return dữ liệu thì sẽ khớp vs kiểu dữ liệu ở số 2
	//	Nếu như có return thì nó là cái step cuối cùng

	public void openUrl(WebDriver driver, String url) {
		// 2 + 4 + 5
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
		return new WebDriverWait(driver, 30).until(ExpectedConditions.alertIsPresent());
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


}
