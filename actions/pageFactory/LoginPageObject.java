package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pageUIs.LoginPageUI;

public class LoginPageObject extends BasePageFactory {
	WebDriver driver;
	
	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	//UI
	@CacheLookup
	@FindBy(xpath = "//input[@id='Email']")
	WebElement emailTextbox;
	
	@FindBy(xpath = "//input[@id='Password']")
	WebElement passwordTextbox;
	
	@FindBy(xpath = "//button[@class='button-1 login-button']")
	WebElement loginButton;
 
	//Action
	public void enterToEmailAddress(String emailAddress) {
		waitForElementVisible(driver, emailTextbox);
		sendkeyToElement(driver, emailTextbox, emailAddress);
		
	}
	// Chứa action dưới dạng hàm của page đó: click/ select/ verify/ getText/...

	public void enterToPassword(String password) {
		waitForElementVisible(driver, passwordTextbox);
		sendkeyToElement(driver, passwordTextbox, password);
		
	}

	public void clickToLoginButton() {
		waitForElementClickable(driver, loginButton);
		clickToElement(driver, loginButton);
		
	}
}
