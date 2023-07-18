package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import graphql.org.antlr.v4.runtime.tree.xpath.XPath;
import pageUIs.HomePageUI;

public class HomePageObject extends BasePageFactory{
	WebDriver driver;
	
	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	PageFactory.initElements(driver, this);
	}

	//UI
	@CacheLookup
	@FindBy(xpath = "//a[@class='ico-register']")
	WebElement registerLink;
	
	@FindBy(xpath = "//a[@class='ico-login']")
	WebElement loginLink;
	
	@FindBy(xpath = "//a[@class='ico-account']")
	WebElement myAccountLink;
	
	//Action
	
	public void clickToRegisterLink() {
	waitForElementClickable(driver, registerLink);
	clickToElement(driver, registerLink);
		
	}

	public void clickToLoginLink() {
	waitForElementClickable(driver, loginLink);
	clickToElement(driver, loginLink);
	}

	public void clickToMyAccountLink() {
	waitForElementClickable(driver, myAccountLink);
	clickToElement(driver, myAccountLink);
				
	}
	
}
