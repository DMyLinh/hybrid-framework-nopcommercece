package pageObjects.userLiveguru;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUI.userLiveguru.HomePageUI;


public class HomePageObject extends BasePage{
	WebDriver driver;

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToAccountLink() {
		waitForElementClickable(driver, HomePageUI.ACCOUNT_LINK);
		clickToElement(driver, HomePageUI.ACCOUNT_LINK);
	}

	public RegisterPageObject openRegisterPage() {
		waitForElementClickable(driver, HomePageUI.REGISTER_ACCOUNT_LINK);
		clickToElement(driver, HomePageUI.REGISTER_ACCOUNT_LINK);	
		
		return new PageGeneratorManager().getRegisterPage(driver);
	}


}
