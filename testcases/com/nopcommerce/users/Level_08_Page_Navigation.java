package com.nopcommerce.users;

import org.testng.annotations.Test;

import commons.BasePage;
import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.user.AddressesPageObject;
import pageObjects.user.CustomerPageObject;
import pageObjects.user.DownloadableProductsPageObject;
import pageObjects.user.HomePageObject;
import pageObjects.user.LoginPageObject;
import pageObjects.user.RegisterPageObject;
import pageObjects.user.RewardPointsPageObject;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level_08_Page_Navigation extends BaseTest {
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

	@Parameters({"browser","userUrl"})
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		driver = getBrowserDriver(browserName, url);
		homePage = PageGeneratorManager.getHomePage(driver);
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
	public void User_02_Switch_Page() {
		// Custormer infor > Downloadable product
		downloadableProductsPage = customerPage.OpenDownloadableProductsPage();
		
		// Downloadable product > Addresses
		addressesPage = downloadableProductsPage.OpenAddressesPage();
		
		// Addresses => Reward point
		rewardPointsPage = addressesPage.OpenRewardPointsPage();
		
		// Reward point => Custormer infor
		customerPage = rewardPointsPage.OpenCustomerPage();
		// Custormer infor => Addresses
		addressesPage = customerPage.OpenAddressesPage();
		
		// Addresses => Downloadable product
		downloadableProductsPage = addressesPage.OpenDownloadableProductsPage();
		
	} 

	@AfterClass
	public void afterClass() {
		quitBrowserDriver();
	}



}
