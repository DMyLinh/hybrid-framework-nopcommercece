package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CustomerPageObject extends BasePageFactory {
	WebDriver driver;	
	
	public CustomerPageObject(WebDriver driver) {
			this.driver = driver;
			PageFactory.initElements(driver, this);
	}

	//UI
	@CacheLookup
	@FindBy(how = How.XPATH, using= "//input[@id='FirstName']")
	WebElement firstNameTextbox;
	
	@FindBy(id = "LastName")
	WebElement lastNameTextbox;
	
	@FindBy(css = "input#Email")
	WebElement emailTextbox;
	
	@FindBy(xpath = "//button[@id='save-info-button']")
	WebElement saveButton;
	
	//Action
	public String  getFirstNameAttributeValue() {
		waitForElementVisible(driver, firstNameTextbox);
		return getElementAttribute(driver, firstNameTextbox, "value");
	}
	
	public String  getLastNameAttributeValue() {
		waitForElementVisible(driver, lastNameTextbox);
		return getElementAttribute(driver, lastNameTextbox, "value");
	}
	
	public String  getEmailAttributeValue() {
		waitForElementVisible(driver, emailTextbox);
		return getElementAttribute(driver, emailTextbox, "value");
	}
	
	



}
