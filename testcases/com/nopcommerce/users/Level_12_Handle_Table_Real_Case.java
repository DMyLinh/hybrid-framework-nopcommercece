package com.nopcommerce.users;

import org.testng.annotations.Test;

import commons.BasePage;
import commons.BaseTest;
import pageObjects.adminLiveguru.AdminLoginPageObject;
import pageObjects.adminLiveguru.ManageCustomerPageObject;
import pageObjects.userLiveguru.HomePageObject;
import pageObjects.userLiveguru.MyAccountPageObject;
import pageObjects.userLiveguru.PageGeneratorManager;
import pageObjects.userLiveguru.RegisterPageObject;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level_12_Handle_Table_Real_Case extends BaseTest {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String emailAddress = getEmailAddress();
	HomePageObject homePage;
	RegisterPageObject registerPage;
	MyAccountPageObject myAccountPage;
	AdminLoginPageObject adminLoginPage;
	ManageCustomerPageObject manageCustomerPage;
	
	private String userNameAdmin = "user01";
	private String passwordAdmin = "guru99com";
	private String userFirstName = "Linh";
	private String userLastName = "TestAuto28";
	private String userName = userFirstName + " " + userLastName;

	@Parameters({"browser","url"})
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		driver = getBrowserDriver(browserName, url);
		homePage = PageGeneratorManager.getHomePage(driver);
	}

	@Test
	public void User_01_Register_Success() {
		homePage.clickToAccountLink();
		registerPage = homePage.openRegisterPage();
		
		registerPage.inputToFirstNameTextBox(userFirstName);
		registerPage.inputToLastNameTextBox(userLastName);
		registerPage.inputToEmailTextBox(emailAddress);
		registerPage.inputToPasswordTextBox("Abcd1234");
		registerPage.inputToConfirmPasswordTextBox("Abcd1234");
		
		myAccountPage = registerPage.clickToResgisterButton();

	}
	
	@Test
	public void User_02_Verify_Name_Email() {
		myAccountPage.openUrl(driver, "http://live.techpanda.org/index.php/backendlogin");
		adminLoginPage =PageGeneratorManager.getAdminLoginPage(driver);
		
		
		
		manageCustomerPage = adminLoginPage.loginAsAdmin(userNameAdmin, passwordAdmin);
		manageCustomerPage.closeIncomingMessagePopUp();
		
		manageCustomerPage.inputToFilterTextbox("Email",emailAddress);
		manageCustomerPage.clickToSearchButton();
		
		
		Assert.assertEquals(manageCustomerPage.getValueResultByColumnNameAndRowIndex("Email","1"), emailAddress);
		Assert.assertEquals(manageCustomerPage.getValueResultByColumnNameAndRowIndex("Name","1"), userName);
		
	}
		

	@AfterClass
	public void afterClass() {
		quitBrowserDriver();
	}



}
