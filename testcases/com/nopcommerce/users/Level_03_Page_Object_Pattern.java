package com.nopcommerce.users;

import org.testng.annotations.Test;

import commons.BasePage;
import pageObjects.CustomerPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.RegisterPageObject;

import org.testng.annotations.BeforeClass;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level_03_Page_Object_Pattern extends BasePage {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String emailAddress = getEmailAddress();
	HomePageObject homePage;
	RegisterPageObject registerPage;
	LoginPageObject loginPage;
	CustomerPageObject customerPage;
	
	

  @BeforeClass
  public void beforeClass() {
	  System.setProperty("webdriver.gecko.driver", projectPath +"\\browserDrivers\\geckodriver.exe");
	  driver = new FirefoxDriver();
	  driver.get("https://demo.nopcommerce.com/");
	  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
  }
  	

  @Test
  public void Register_01_Empty_Data() {
	  homePage = new HomePageObject(driver);
	  
	  homePage.clickToRegisterLink();
	  
	  // Để register chạy tiếp flow
	  registerPage = new RegisterPageObject(driver);
	  registerPage.clickToRegisterButton();
	  
 	  
	  Assert.assertEquals(registerPage.getFirstNameErrorMessage(), "First name is required.");
	  Assert.assertEquals(registerPage.getLastNameErrorMessage(), "Last name is required.");
	  Assert.assertEquals(registerPage.getEmailErrorMessage(), "Email is required.");
	  Assert.assertEquals(registerPage.getPasswordErrorMessage(), "Password is required.");
	  Assert.assertEquals(registerPage.getConfirmPasswordErrorMessage(), "Password is required.");
  
  }
  
  @Test
  public void Register_02_Invalid_Email() {
	  registerPage.clickToHomePageLogo();
	  homePage = new HomePageObject(driver);

	  homePage.clickToRegisterLink();
	  
	  registerPage = new RegisterPageObject(driver);
	  
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
	  registerPage.clickToHomePageLogo();
	  homePage = new HomePageObject(driver);

	  homePage.clickToRegisterLink();
	  
	  registerPage = new RegisterPageObject(driver);

	  registerPage.enterToFirstNameTextbox("John");
	  registerPage.enterToLastNameTextbox("Witch");
	  registerPage.enterToEmailTextbox(emailAddress);
	  registerPage.enterToPasswordTextbox("Abc");
	  registerPage.enterToConfirmPasswordTextbox("Abcd");
	  
	  registerPage.clickToRegisterButton();
	  
	  Assert.assertEquals(registerPage.getPasswordErrorMessage(), 
			  "Password must meet the following rules:\nmust have at least 6 characters");
  }
  
  @Test
  public void Register_04_Incorect_Confirm_Password() {
	  registerPage.clickToHomePageLogo();
	  homePage = new HomePageObject(driver);

	  homePage.clickToRegisterLink();
	  
	  registerPage = new RegisterPageObject(driver);

	  registerPage.enterToFirstNameTextbox("John");
	  registerPage.enterToLastNameTextbox("Witch");
	  registerPage.enterToEmailTextbox(emailAddress);
	  registerPage.enterToPasswordTextbox("Abcd1234");
	  registerPage.enterToConfirmPasswordTextbox("Abcd");
	  
	  registerPage.clickToRegisterButton();
	  
	  Assert.assertEquals(registerPage.getConfirmPasswordErrorMessage(), 
			  "The password and confirmation password do not match.");
  }
  
  @Test
  public void Register_05_Success() {
	  registerPage.clickToHomePageLogo();
	  homePage = new HomePageObject(driver);

	  homePage.clickToRegisterLink();
	  
	  registerPage = new RegisterPageObject(driver);

	  registerPage.enterToFirstNameTextbox("John");
	  registerPage.enterToLastNameTextbox("Witch");
	  registerPage.enterToEmailTextbox(emailAddress);
	  registerPage.enterToPasswordTextbox("Abcd1234");
	  registerPage.enterToConfirmPasswordTextbox("Abcd1234");
	  
	  registerPage.clickToRegisterButton();
	  
	  Assert.assertEquals(registerPage.getRegisterSuccessMessage(), 
			  "Your registration completed");

	  registerPage.clickToHomePageLogo();
	  homePage = new HomePageObject(driver);
	  
	  homePage.clickToLoginLink();
	  
	  loginPage = new LoginPageObject(driver);
	  
	  loginPage.enterToEmailAddress(emailAddress);
	  loginPage.enterToPassword("Abcd1234");
	  loginPage.clickToLoginButton();
	  
	  homePage = new HomePageObject(driver);
	  homePage.clickToMyAccountLink();
	  
	  customerPage = new CustomerPageObject(driver);
	  
	  Assert.assertEquals(customerPage.getFirstNameAttributeValue(), "John");
	  Assert.assertEquals(customerPage.getLastNameAttributeValue(), "Witch");
	  Assert.assertEquals(customerPage.getEmailAttributeValue(), emailAddress);

  }
  
   
  @AfterClass
  public void afterClass() {
	  driver.quit();
  }
  
  public String getEmailAddress() {
	  Random rand =new Random();
	  return "john" + rand.nextInt(9999) +"@gmail.com";
  }

}
