package pageUIs.jquery;

public class UploadFilePageUI {
	public static final String FILE_LOADED_BY_NAME = "xpath=//p[@class='name' and text()='%s']";
	public static final String MULTIPLE_START_BUTTON = "css=table button.start";
	public static final String FILE_UPLOADED_BY_NAME = "xpath=//p[@class='name']/a[text()='%s']";
	
	public static final String ICON_LOADING ="Css=div.spinner-border";
	public static final String UPLOAD_BUTTON ="Xpath=//button[text()='Upload Files']";
	public static final String PROCESS_BAR ="css=div.progress-bar";
	public static final String MESSAGE_UPLOAD_SUCCESS ="CSS=div.mainUploadSuccess div.border-success.text-white";
	public static final String GO_FILE_UPLOADED_BY_NAME ="XPATH=//span[@class='contentName' and text()='%s']";
	public static final String AJAX_LINK ="css=div.mainUploadSuccessLink a.ajaxLink";

}
