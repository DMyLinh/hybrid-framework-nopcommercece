package com.nopcommerce.users;

import org.testng.annotations.Test;

import commons.BasePage;
import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.user.CustomerPageObject;
import pageObjects.user.HomePageObject;
import pageObjects.user.LoginPageObject;
import pageObjects.user.RegisterPageObject;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level_06_Page_Generator_3 extends BaseTest {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String emailAddress = getEmailAddress();
	HomePageObject homePage;
	RegisterPageObject registerPage;
	LoginPageObject loginPage;
	CustomerPageObject customerPage;

	@Parameters({"browser","userUrl"})
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		driver = getBrowserDriver(browserName, url);
		homePage = PageGeneratorManager.getHomePage(driver);
	}

	@Test
	public void Register_01_Empty_Data() {
		

		registerPage = homePage.clickToRegisterLink();
		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getFirstNameErrorMessage(), "First name is required.");
		Assert.assertEquals(registerPage.getLastNameErrorMessage(), "Last name is required.");
		Assert.assertEquals(registerPage.getEmailErrorMessage(), "Email is required.");
		Assert.assertEquals(registerPage.getPasswordErrorMessage(), "Password is required.");
		Assert.assertEquals(registerPage.getConfirmPasswordErrorMessage(), "Password is required.");

	}

	@Test
	public void Register_02_Invalid_Email() {
		
		homePage = registerPage.clickToHomePageLogo();
		registerPage = homePage.clickToRegisterLink();

		registerPage.enterToFirstNameTextbox("John");
		registerPage.enterToLastNameTextbox("Witch");
		registerPage.enterToEmailTextbox("abc");
		registerPage.enterToPasswordTextbox("Abcd1234");
		registerPage.enterToConfirmPasswordTextbox("Abcd1234");

		registerPage.clickToRegisterButton();
		Assert.assertEquals(registerPage.getEmailErrorMessage(), "Wrong email");

	}

	@Test
	public void Register_03_Invalid_Password() {
		homePage = registerPage.clickToHomePageLogo();
		registerPage = homePage.clickToRegisterLink();

		registerPage.enterToFirstNameTextbox("John");
		registerPage.enterToLastNameTextbox("Witch");
		registerPage.enterToEmailTextbox(emailAddress);
		registerPage.enterToPasswordTextbox("Abc");
		registerPage.enterToConfirmPasswordTextbox("Abcd");

		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getPasswordErrorMessage(), "Password must meet the following rules:\nmust have at least 6 characters");
	}

	@Test
	public void Register_04_Incorect_Confirm_Password() {
		homePage = registerPage.clickToHomePageLogo();
		registerPage = homePage.clickToRegisterLink();

		registerPage.enterToFirstNameTextbox("John");
		registerPage.enterToLastNameTextbox("Witch");
		registerPage.enterToEmailTextbox(emailAddress);
		registerPage.enterToPasswordTextbox("Abcd1234");
		registerPage.enterToConfirmPasswordTextbox("Abcd");

		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getConfirmPasswordErrorMessage(), "The password and confirmation password do not match.");
	}

	@Test
	public void Register_05_Success() {
		homePage = registerPage.clickToHomePageLogo();
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

	@AfterClass
	public void afterClass() {
		quitBrowserDriver();
	}



}
