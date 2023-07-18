package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.CustomerPageUI;

public class CustomerPageObject extends BasePage {

	WebDriver driver;
	
	public CustomerPageObject(WebDriver driver) {
		this.driver = driver;
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
