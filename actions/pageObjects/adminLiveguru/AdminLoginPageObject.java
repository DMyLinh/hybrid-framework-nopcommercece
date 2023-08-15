package pageObjects.adminLiveguru;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageObjects.userLiveguru.PageGeneratorManager;
import pageUI.adminLiveguru.AdminLoginPageUI;

public class AdminLoginPageObject extends BasePage {
	WebDriver driver;

	public AdminLoginPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public void inputToUserNameTextBoxAdmin(String userNameAdmin) {
		waitForElementVisible(driver, AdminLoginPageUI.USER_NAME_TEXT_BOX_ADMIN);
		sendkeyToElement(driver, AdminLoginPageUI.USER_NAME_TEXT_BOX_ADMIN, userNameAdmin);
	}
	
	public void inputToPasswordTextBoxAdmin(String passwordAdmin) {
		waitForElementVisible(driver, AdminLoginPageUI.PASSWORD_TEXT_BOX_ADMIN);
		sendkeyToElement(driver, AdminLoginPageUI.PASSWORD_TEXT_BOX_ADMIN, passwordAdmin);
	}
	
	public void clickToLoginButton() {
		waitForElementClickable(driver, AdminLoginPageUI.LOGIN_BUTTON_ADMIN);
		clickToElement(driver, AdminLoginPageUI.LOGIN_BUTTON_ADMIN);
	}

	public ManageCustomerPageObject loginAsAdmin(String userNameAdmin, String passwordAdmin) {
		inputToUserNameTextBoxAdmin(userNameAdmin);
		inputToPasswordTextBoxAdmin(passwordAdmin);
		clickToLoginButton();
		
		return new PageGeneratorManager().getManageCustomerPage(driver);
		
	}

}
