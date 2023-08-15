package pageObjects.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.users.LoginPageUI;

public class LoginPageObject extends BasePage {

	WebDriver driver;
	
	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	
	public void enterToEmailAddress(String emailAddress) {
		waitForElementVisible(driver, LoginPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.EMAIL_TEXTBOX, emailAddress);
		
	}
	// Chứa action dưới dạng hàm của page đó: click/ select/ verify/ getText/...

	public void enterToPassword(String password) {
		waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
		
	}

	public void clickToLoginButton() {
		waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
		
	}

	public HomePageObject LoginAsUser(String emailAddress, String password) {
		enterToEmailAddress(emailAddress);
		enterToPassword(password);	
		clickToLoginButton();
		return PageGeneratorManager.getHomePage(driver);
		
	}

}
