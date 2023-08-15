package pageUI.adminLiveguru;

public class ManageCustomerPageUI {
	public static final String COLUMN_INDEX_BY_COLUMN_NAME ="xpath=//span[text()='%s']/ancestor::th/preceding-sibling::th";
	public static final String INPUT_FITER_TEXTBOX_BY_COLUMN_INDEX ="xpath=//table[@id='customerGrid_table']//tr[@class='filter']/th[%s]//input";
	public static final String ROW_VALUE_BY_ROW_INDEX_AND_COLUMN_INDEX ="xpath=//table[@id='customerGrid_table']//tbody/tr[%s]/td[%s]";
	public static final String SEARCH_BUTTON ="xpath=//button//span[text()='Search']";
	public static final String CLOSE_POPUP_BUTTON ="xpath=//a[@title='close']";

}
