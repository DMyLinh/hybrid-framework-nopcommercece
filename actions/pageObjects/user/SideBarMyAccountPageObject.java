package pageObjects.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.users.SideBarMyAccountPageUI;

public class SideBarMyAccountPageObject extends BasePage {
 WebDriver driver;

public SideBarMyAccountPageObject(WebDriver driver) {
	this.driver = driver;
}

public AddressesPageObject OpenAddressesPage() {
	waitForElementClickable(driver, SideBarMyAccountPageUI.ADDRESSES_PAGE_LINK);
	clickToElement(driver, SideBarMyAccountPageUI.ADDRESSES_PAGE_LINK);
	return PageGeneratorManager.getAddressesPage(driver);
}

public RewardPointsPageObject OpenRewardPointsPage() {
	waitForElementClickable(driver, SideBarMyAccountPageUI.REWARD_POINTS_PAGE_LINK);
	clickToElement(driver, SideBarMyAccountPageUI.REWARD_POINTS_PAGE_LINK);
	return PageGeneratorManager.getRewardPointsPage(driver);
}

public DownloadableProductsPageObject OpenDownloadableProductsPage() {
	waitForElementClickable(driver, SideBarMyAccountPageUI.DOWNLOADABLE_PRODUCTS_LINK);
	clickToElement(driver, SideBarMyAccountPageUI.DOWNLOADABLE_PRODUCTS_LINK);
	return PageGeneratorManager.getDownloadableProductsPage(driver);	
}

public CustomerPageObject OpenCustomerPage() {
	waitForElementClickable(driver, SideBarMyAccountPageUI.CUSTOMER_PAGE_LINK);
	clickToElement(driver, SideBarMyAccountPageUI.CUSTOMER_PAGE_LINK);
	return PageGeneratorManager.getCustomerPage(driver);
	
}

public SideBarMyAccountPageObject openDynamicSideBarPage(String pageName) {
	waitForElementClickable(driver, SideBarMyAccountPageUI.DYNAMIC_SIDEBAR_LINK, pageName);
	clickToElement(driver, SideBarMyAccountPageUI.DYNAMIC_SIDEBAR_LINK, pageName);
	
	switch (pageName) {
	case "Customer info":
		return PageGeneratorManager.getCustomerPage(driver);
		
	case "Addresses":
		return PageGeneratorManager.getAddressesPage(driver);
		
	case "Reward points":
		return PageGeneratorManager.getRewardPointsPage(driver);
		
	case "Downloadable products":
		return PageGeneratorManager.getDownloadableProductsPage(driver);
	default:
		new RuntimeException("Sidebar page name incorrect.");
		return null;
	}
}

public void openDynamicSideBarPageByName(String pageName) {
	waitForElementClickable(driver, SideBarMyAccountPageUI.DYNAMIC_SIDEBAR_LINK, pageName);
	clickToElement(driver, SideBarMyAccountPageUI.DYNAMIC_SIDEBAR_LINK, pageName);
}
 
}
