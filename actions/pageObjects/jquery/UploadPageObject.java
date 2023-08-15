package pageObjects.jquery;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIs.jquery.UploadFilePageUI;

public class UploadPageObject extends BasePage{
	WebDriver driver;

	public UploadPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isFileLoadedSuccess(String fileName) {
		waitForElementClickable(driver, UploadFilePageUI.FILE_LOADED_BY_NAME, fileName);
		return isElementDisplayed(driver, UploadFilePageUI.FILE_LOADED_BY_NAME, fileName);
	}

	public void clickStartButtonForEachFile() {
		List<WebElement> startButtons = getListElement(driver, UploadFilePageUI.MULTIPLE_START_BUTTON);
		for (WebElement startButton : startButtons) {
			waitForElementClickable(driver, startButton);
			clickToElement(driver, startButton);
		}		
	}

	public boolean isFileUploadedSuccess(String fileName) {
		waitForElementClickable(driver, UploadFilePageUI.FILE_UPLOADED_BY_NAME, fileName);
		return isElementDisplayed(driver, UploadFilePageUI.FILE_UPLOADED_BY_NAME, fileName);
		
	}

	public boolean isIconLoadingDisappear() {
		return waitForElementInvisible(driver, UploadFilePageUI.ICON_LOADING);
		
	}

	public void goToUploadPage() {
		waitForElementClickable(driver, UploadFilePageUI.UPLOAD_BUTTON);
		clickToElement(driver, UploadFilePageUI.UPLOAD_BUTTON);
	}

	public String getMainUploadSuccess() {
		waitForElementVisible(driver, UploadFilePageUI.MESSAGE_UPLOAD_SUCCESS);
		
		return getElementText(driver, UploadFilePageUI.MESSAGE_UPLOAD_SUCCESS);
	}

	public boolean isFilesUploaded(String fileName) {
		waitForElementVisible(driver, UploadFilePageUI.GO_FILE_UPLOADED_BY_NAME, fileName);
		return isElementDisplayed(driver, UploadFilePageUI.GO_FILE_UPLOADED_BY_NAME, fileName);
	}

	public void clickToAjaxLink() {
		waitForElementClickable(driver, UploadFilePageUI.AJAX_LINK);
		clickToElement(driver, UploadFilePageUI.AJAX_LINK);
		
	}
	
}
