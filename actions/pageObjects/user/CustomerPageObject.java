package pageObjects.user;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

import pageUIs.users.CustomerPageUI;

public class CustomerPageObject extends SideBarMyAccountPageObject {

	WebDriver driver;
	
	public CustomerPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	public CustomerPageObject(WebDriver driver, long timeout) {
		super(driver);
		this.driver = driver;
		this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	
	public String getFirstNameAttributeValue() {
		waitForElementVisible(driver, CustomerPageUI.FIRST_NAME_TEXTBOX);
		return getElementAttribute(driver, CustomerPageUI.FIRST_NAME_TEXTBOX, "value");
	}
	// Chứa action dưới dạng hàm của page đó: click/ select/ verify/ getText/...

	public String getLastNameAttributeValue() {
		waitForElementVisible(driver, CustomerPageUI.LAST_NAME_TEXTBOX);
		return getElementAttribute(driver, CustomerPageUI.LAST_NAME_TEXTBOX, "value");
	}

	public String getEmailAttributeValue() {
		waitForElementVisible(driver, CustomerPageUI.EMAIL_TEXTBOX);
		return getElementAttribute(driver, CustomerPageUI.EMAIL_TEXTBOX, "value");
	}



}
