package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pageUIs.RegisterPageUI;

public class RegisterPageObject extends BasePageFactory {
	WebDriver driver;	
	
	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	//UI
	@CacheLookup
	@FindBy(xpath ="//input[@id='FirstName']")
	WebElement firstNameTextbox;
	
	@FindBy(xpath ="//input[@id='LastName']")
	WebElement lastNameTextbox;
	
	@FindBy(xpath ="//input[@id='Email']")
	WebElement emailTextbox;
	
	@FindBy(xpath ="//input[@id='Password']")
	WebElement passwordTextbox;
	
	@FindBy(xpath ="//input[@id='ConfirmPassword']")
	WebElement confirmPasswordTextbox;
	
	@FindBy(xpath ="//span[@id='FirstName-error']")
	WebElement firstNameErrorMessage;
	
	@FindBy(xpath ="//span[@id='LastName-error']")
	WebElement lastNameErrorMessage;
	
	@FindBy(xpath ="//span[@id='Email-error']")
	WebElement emailErrorMessage;
	
	@FindBy(xpath ="//span[@id='Password-error']")
	WebElement passWordErrorMessage;
	
	@FindBy(xpath ="//span[@id='ConfirmPassword-error']")
	WebElement confirmPasswordErrorMessage;
	
	@FindBy(xpath ="//div[@class='result']")
	WebElement registerSuccessMessage;
	
	@FindBy(xpath ="//button[@id='register-button']")
	WebElement registerButton;
	
	@FindBy(xpath ="//a[@class='ico-login']")
	WebElement loginLink;
	
	@FindBy(xpath ="//img[@alt='nopCommerce demo store']")
	WebElement homepageLogoImage;
	
	
	//Action
	public void clickToRegisterButton() {
		waitForElementClickable(driver, registerButton);
		clickToElement(driver, registerButton);
	}

	public String getFirstNameErrorMessage() {
		waitForElementVisible(driver, firstNameErrorMessage);
		return getElementText(driver, firstNameErrorMessage);
	}

	public String getLastNameErrorMessage() {
		waitForElementVisible(driver, lastNameErrorMessage);
		return getElementText(driver, lastNameErrorMessage);
	}

	public String getEmailErrorMessage() {
		waitForElementVisible(driver, emailErrorMessage);
		return getElementText(driver, emailErrorMessage);
	}

	public String getPasswordErrorMessage() {
		waitForElementVisible(driver, passWordErrorMessage);
		return getElementText(driver, passWordErrorMessage);
	}

	public String getConfirmPasswordErrorMessage() {
		waitForElementVisible(driver, confirmPasswordErrorMessage);
		return getElementText(driver, confirmPasswordErrorMessage);
	}


	public void clickToHomePageLogo() {
		waitForElementClickable(driver, homepageLogoImage);
		clickToElement(driver, homepageLogoImage);
	}

	public void enterToLastNameTextbox(String lastname) {
		waitForElementVisible(driver, lastNameTextbox);
		sendkeyToElement(driver, lastNameTextbox, lastname);
		
	}

	public void enterToFirstNameTextbox(String firstName) {
		waitForElementVisible(driver, firstNameTextbox);
		sendkeyToElement(driver, firstNameTextbox, firstName);		
	}

	public void enterToEmailTextbox(String email) {
		waitForElementVisible(driver, emailTextbox);
		sendkeyToElement(driver, emailTextbox, email);		
	}

	public void enterToPasswordTextbox(String password) {
		waitForElementVisible(driver, passwordTextbox);
		sendkeyToElement(driver, passwordTextbox, password);		
	}

	public void enterToConfirmPasswordTextbox(String confirmPassword) {
		waitForElementVisible(driver, confirmPasswordTextbox);
		sendkeyToElement(driver, confirmPasswordTextbox, confirmPassword);		
	}

	public String getRegisterSuccessMessage() {
		waitForElementVisible(driver, registerSuccessMessage);
		return getElementText(driver, registerSuccessMessage);
	}
	
	

}
