package pageObjects.userLiveguru;

import org.openqa.selenium.WebDriver;

import pageObjects.adminLiveguru.AdminLoginPageObject;
import pageObjects.adminLiveguru.ManageCustomerPageObject;


public class PageGeneratorManager {
	public static HomePageObject getHomePage(WebDriver driver) {
		return new HomePageObject(driver);
	}

	public static RegisterPageObject getRegisterPage(WebDriver driver) {
		return new RegisterPageObject(driver) ;
	}
	
	public static MyAccountPageObject getMyAccountPage(WebDriver driver) {
		return new MyAccountPageObject(driver) ;
	}
	
	public static AdminLoginPageObject getAdminLoginPage(WebDriver driver) {
		return new AdminLoginPageObject(driver) ;
	}
	
	public static ManageCustomerPageObject getManageCustomerPage(WebDriver driver) {
		return new ManageCustomerPageObject(driver) ;
	}
}
