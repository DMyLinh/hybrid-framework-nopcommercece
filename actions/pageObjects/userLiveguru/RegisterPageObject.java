package pageObjects.userLiveguru;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUI.userLiveguru.RegisterPageUI;

public class RegisterPageObject extends BasePage{
	WebDriver driver;

	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputToFirstNameTextBox(String firstName) {
		waitForElementVisible(driver, RegisterPageUI.FIRST_NAME_TEXT_BOX);
		sendkeyToElement(driver, RegisterPageUI.FIRST_NAME_TEXT_BOX, firstName);
	}

	public void inputToLastNameTextBox(String lastName) {
		waitForElementVisible(driver, RegisterPageUI.LAST_NAME_TEXT_BOX);
		sendkeyToElement(driver, RegisterPageUI.LAST_NAME_TEXT_BOX, lastName);		
	}

	public void inputToEmailTextBox(String emailAddress) {
		waitForElementVisible(driver, RegisterPageUI.EMAIL_TEXT_BOX);
		sendkeyToElement(driver, RegisterPageUI.EMAIL_TEXT_BOX, emailAddress);		
	}

	public void inputToPasswordTextBox(String password) {
		waitForElementVisible(driver, RegisterPageUI.PASSWORD_TEXT_BOX);
		sendkeyToElement(driver, RegisterPageUI.PASSWORD_TEXT_BOX, password);		
	}

	public void inputToConfirmPasswordTextBox(String confirmPassword) {
		waitForElementVisible(driver, RegisterPageUI.CONFIRMATION_PASSWORD_TEXT_BOX);
		sendkeyToElement(driver, RegisterPageUI.CONFIRMATION_PASSWORD_TEXT_BOX, confirmPassword);		
	}

	public MyAccountPageObject clickToResgisterButton() {
		waitForElementClickable(driver, RegisterPageUI.REGISTER_BUTTON);
		clickToElement(driver, RegisterPageUI.REGISTER_BUTTON);
		return new PageGeneratorManager().getMyAccountPage(driver);
	}
	
	

}
