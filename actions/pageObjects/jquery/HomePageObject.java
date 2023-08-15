package pageObjects.jquery;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIs.jquery.HomePageUI;

public class HomePageObject extends BasePage {

	WebDriver driver;

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public void inputToColumnTextboxByName(String columnName, String valueToSend) {
		waitForElementVisible(driver, HomePageUI.COLUMN_TEXTBOX_BY_NAME, columnName);
		sendkeyToElement(driver, HomePageUI.COLUMN_TEXTBOX_BY_NAME, valueToSend, columnName);
		
	}
	
	public void clickToPageLinkByNumber(String pageNumber  ) {
		waitForElementClickable(driver, HomePageUI.PAGE_LINK_BY_NUMBER, pageNumber );
		clickToElement(driver, HomePageUI.PAGE_LINK_BY_NUMBER, pageNumber);
		
	}
	
	public boolean isPageActiveByNumber(String pageNumber) {
		waitForElementClickable(driver,HomePageUI.PAGE_LINK_ACTIVE, pageNumber);
		return isElementDisplayed(driver,HomePageUI.PAGE_LINK_ACTIVE, pageNumber);
	}
	
	public boolean isRowValueDisplayed(String females, String country, String males, String total) {
		waitForElementClickable(driver,HomePageUI.DYNAMIC_ROW_VALUE, females, country, males, total);
		return isElementDisplayed(driver,HomePageUI.DYNAMIC_ROW_VALUE, females, country, males, total);
	}
	
	public void clickToRowActionByCountryName (String country, String rowAction) {
		waitForElementClickable(driver,HomePageUI.ROW_ACTION_BY_COUNTRY_NAME, country, rowAction);
		clickToElement(driver, HomePageUI.ROW_ACTION_BY_COUNTRY_NAME, country, rowAction);

	}

	public List<String> getAllPageValuesByColumnName(String columnName) {
		List<String> allValues = new ArrayList<String>();
		
		// Bước 1: Lấy tất cả các page
		List<WebElement> allPageLinks=  getListElement(driver, HomePageUI.ALL_PAGE_LINK);

		int columnIndex = getListElementSize(driver, HomePageUI.COLUMN_INDEX_BY_COLUMN_NAME, columnName) +1;
		
		// Bước 2: Duyệt qua từng page
		for (WebElement pageLink : allPageLinks) {
			pageLink.click();
			
			// Bước 3: Lấy tất cả dữ liệu từng cột trong page đó -> lưu vào list/ set/...
			List<WebElement> allRowValues = getListElement(driver, HomePageUI.ALL_VALUES_BY_COLUMN_INDEX, String.valueOf(columnIndex));
			
			for (WebElement rowValue : allRowValues) {
				allValues.add(rowValue.getText());
				
			}
		}
		// In ra hết tất cả giá trị của mỗi cột trong page
		// Sort ASC/DESC
		return allValues;
	}


	public void enterToTextBoxByColumnNameAndRowIndex(String columnName, String rowIndex, String valueToSend) {
		int columnIndex = getListElementSize(driver, HomePageUI.DYNAMIC_COLUMN_INDEX_BY_COLUMN_NAME, columnName) +1;
		waitForElementVisible(driver, HomePageUI.DYNAMIC_TEXTBOX_BY_ROW_INDEX_AND_COLUMN_INDEX, rowIndex, String.valueOf(columnIndex));
		sendkeyToElement(driver, HomePageUI.DYNAMIC_TEXTBOX_BY_ROW_INDEX_AND_COLUMN_INDEX, valueToSend, rowIndex, String.valueOf(columnIndex));
	}

	public void selectToDropdownListByColumnNameAndRowIndex(String columnName, String rowIndex, String dropdownItem) {
		int columnIndex = getListElementSize(driver, HomePageUI.DYNAMIC_COLUMN_INDEX_BY_COLUMN_NAME, columnName) +1;
		waitForElementClickable(driver, HomePageUI.DYNAMIC_DROPDOWN_BY_ROW_INDEX_AND_COLUMN_INDEX, rowIndex, String.valueOf(columnIndex));
		selectDropdown(driver, HomePageUI.DYNAMIC_DROPDOWN_BY_ROW_INDEX_AND_COLUMN_INDEX, dropdownItem, rowIndex, String.valueOf(columnIndex));
	}

	public void clickToCheckboxByColumnNameAndRowIndex(String columnName, String rowIndex) {
		int columnIndex = getListElementSize(driver, HomePageUI.DYNAMIC_COLUMN_INDEX_BY_COLUMN_NAME, columnName) +1;
		waitForElementClickable(driver, HomePageUI.DYNAMIC_CHECKBOX_BY_ROW_INDEX_AND_COLUMN_INDEX, rowIndex, String.valueOf(columnIndex));
		checkToCheckboxRadio(driver, HomePageUI.DYNAMIC_CHECKBOX_BY_ROW_INDEX_AND_COLUMN_INDEX, rowIndex, String.valueOf(columnIndex));
	}
}
