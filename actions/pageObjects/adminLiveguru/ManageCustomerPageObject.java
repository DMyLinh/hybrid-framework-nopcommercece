package pageObjects.adminLiveguru;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUI.adminLiveguru.ManageCustomerPageUI;

public class ManageCustomerPageObject extends BasePage{
	WebDriver driver;

	public ManageCustomerPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputToFilterTextbox(String columnName, String valueToSend) {
		List<WebElement> allFilterName = getListElement(driver, ManageCustomerPageUI.COLUMN_INDEX_BY_COLUMN_NAME, columnName);
		
		int columnIndex = allFilterName.size() + 1;
		
		waitForElementVisible(driver, ManageCustomerPageUI.INPUT_FITER_TEXTBOX_BY_COLUMN_INDEX, String.valueOf(columnIndex));
		sendkeyToElement(driver, ManageCustomerPageUI.INPUT_FITER_TEXTBOX_BY_COLUMN_INDEX, valueToSend, String.valueOf(columnIndex));
	}

	public void clickToSearchButton() {
		waitForElementClickable(driver, ManageCustomerPageUI.SEARCH_BUTTON);
		clickToElement(driver, ManageCustomerPageUI.SEARCH_BUTTON);
	}

	public String getValueResultByColumnNameAndRowIndex(String columnName, String rowIndex) {
		List<WebElement> allColumnName = getListElement(driver, ManageCustomerPageUI.COLUMN_INDEX_BY_COLUMN_NAME, columnName);
		
		int columnIndex = allColumnName.size() + 1;	
		waitForElementVisible(driver, ManageCustomerPageUI.ROW_VALUE_BY_ROW_INDEX_AND_COLUMN_INDEX, rowIndex, String.valueOf(columnIndex));
		return getElementText(driver, ManageCustomerPageUI.ROW_VALUE_BY_ROW_INDEX_AND_COLUMN_INDEX, rowIndex, String.valueOf(columnIndex));
		
	}

	public void closeIncomingMessagePopUp() {
		waitForElementClickable(driver, ManageCustomerPageUI.CLOSE_POPUP_BUTTON);
		clickToElement(driver, ManageCustomerPageUI.CLOSE_POPUP_BUTTON);
	}
	
	

}
