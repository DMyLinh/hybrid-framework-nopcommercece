package commons;

import java.io.File;

public class GlobalConstants {
	// Chứa thông tin dùng chung cho cả framework
	// Server url: dev/testing/staging/product
	// Database: dev/testing/staging/product
	// timeout: short/long
	// UserName/ Password
	// Third party: Paypal sandbox (tai khoan ao de test thanh toan)
	// Download/upload
	// Relative project path
	// OS name
	// Cloud Testing: Browserstack/ saucelab/ crossbrowserTesting (Access Token/ ID)
	
	public static final String DEV_USER_URL ="https://demo.nopcommerce.com/";
	public static final String DEV_ADMIN_URL ="https://admin-demo.nopcommerce.com/";
	public static final long SHORT_TIMEOUT = 5;
	public static final long LONG_TIMEOUT = 30;
	public static final String DEV_ADMIN_USERNAME ="admin@yourstore.com";
	public static final String DEV_ADMIN_PASSWORD ="admin";
	public static final String OS_NAME = System.getProperty("os.name");
	public static final String RELATIVE_PROJECT_PATH = System.getProperty("user.dir");
	public static final String UPLOAD_PATH = RELATIVE_PROJECT_PATH + File.separator +"uploadFiles" +File.separator;
	public static final String DOWNLOAD_PATH = RELATIVE_PROJECT_PATH + File.separator+ "downloadFiles" + File.separator;
}
