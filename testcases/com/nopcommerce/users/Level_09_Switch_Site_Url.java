package com.nopcommerce.users;

import org.testng.annotations.Test;

import commons.BasePage;
import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObject.admin.AdminDashBoardPageObject;
import pageObject.admin.AdminLoginPageObject;
import pageObjects.user.AddressesPageObject;
import pageObjects.user.CustomerPageObject;
import pageObjects.user.DownloadableProductsPageObject;
import pageObjects.user.HomePageObject;
import pageObjects.user.LoginPageObject;
import pageObjects.user.RegisterPageObject;
import pageObjects.user.RewardPointsPageObject;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import static org.testng.Assert.assertTrue;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level_09_Switch_Site_Url extends BaseTest {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String emailAddress = getEmailAddress();
	// Kế thừa basePage
	HomePageObject homePage;
	RegisterPageObject registerPage;
	LoginPageObject loginPage;
	
	// Kế thừa sidebar
	CustomerPageObject customerPage;
	DownloadableProductsPageObject downloadableProductsPage;
	AddressesPageObject addressesPage;
	RewardPointsPageObject rewardPointsPage;
	
	private AdminLoginPageObject adminLoginPage;
	private AdminDashBoardPageObject adminDashboardPage;
	
	private String userUrl, adminUrl;

	@Parameters({"browser","userUrl", "adminUrl"})
	@BeforeClass
	public void beforeClass(String browserName, String userUrl, String adminUrl) {
		driver = getBrowserDriver(browserName, userUrl);
		homePage = PageGeneratorManager.getHomePage(driver);
		
		this.userUrl = userUrl;
		this.adminUrl = adminUrl;
	}

	@Test
	public void User_01_Register_Success() {
		registerPage = homePage.clickToRegisterLink();
		
		registerPage.enterToFirstNameTextbox("John");
		registerPage.enterToLastNameTextbox("Witch");
		registerPage.enterToEmailTextbox(emailAddress);
		registerPage.enterToPasswordTextbox("Abcd1234");
		registerPage.enterToConfirmPasswordTextbox("Abcd1234");

		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

		homePage = registerPage.clickToHomePageLogo();

		loginPage= homePage.clickToLoginLink();

		homePage = loginPage.LoginAsUser(emailAddress, "Abcd1234");

		customerPage = homePage.clickToMyAccountLink();

		Assert.assertEquals(customerPage.getFirstNameAttributeValue(), "John");
		Assert.assertEquals(customerPage.getLastNameAttributeValue(), "Witch");
		Assert.assertEquals(customerPage.getEmailAttributeValue(), emailAddress);

	}
	
	@Test
	public void User_02_Switch_Url() {
		// Customer page
		
		
		// Logout ra từ trang user
		homePage = customerPage.userAbleToLogout(driver);
		
		// Qua trang Admin
		homePage.openUrl(driver, adminUrl);
		adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);
		
		// Login thành công
		adminDashboardPage = adminLoginPage.loginAsAdmin("admin@yourstore.com", "admin");
		
		Assert.assertTrue(adminDashboardPage.isPageLoadedSuccess(driver));
		
		
		// Log out từ trang admin
		adminLoginPage = adminDashboardPage.adminAbleToLogout(driver);
		
		// Qua trang user
		adminLoginPage.openUrl(driver, userUrl);
		homePage = PageGeneratorManager.getHomePage(driver);

		// Login vào
		loginPage= homePage.clickToLoginLink();

		homePage = loginPage.LoginAsUser(emailAddress, "Abcd1234");
	} 

	@AfterClass
	public void afterClass() {
		quitBrowserDriver();
	}



}
