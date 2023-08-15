package pageObjects.user;

import org.openqa.selenium.WebDriver;
import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.users.HomePageUI;

public class HomePageObject extends BasePage {
	WebDriver driver;
	
	// Hàm khởi tạo của 1 class
	// Cùng tên vs Class
	// Không có kiểu trả về
	// Chạy đầu tiên khi class được gọi tới
	// 1 Class nếu ko được define hàm khởi tạo nào thì mặc định nó sẽ có 1 hàm khởi tạo rỗng
	// Nếu được define nó sẽ ưu tiên gọi tới hàm được define đó (ko dùng mặc định nữa)
	// Có thể có 1 hoặc nhiều tham số hoặc 0 tham số
	// 1 Class có thể có nhiều hàm khởi tạo
	// Nếu class hiện tại đang kế thừa 1 class cha - thì khi tạo hàm khởi tạo nó sẽ có từ khóa super
	// => Gọi tới hàm khởi tạo của class cha
	// Nếu class hiện tại không kế thừa class nào hết thì mặc định nó sẽ cho kế thừa class Object
	// Từ khóa this: 1 Class có 2 biến cùng tên (Global/ Local)
	// Global: Phạm vi khai báo thuộc Class
	// Local: Phạm vi khai báo thuộc tham số/ trong hàm
	
	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public RegisterPageObject clickToRegisterLink() {
	waitForElementClickable(driver, HomePageUI.REGISTER_LINK);
	clickToElement(driver, HomePageUI.REGISTER_LINK);
	return PageGeneratorManager.getRegisterPage(driver);
		
	}

	public LoginPageObject clickToLoginLink() {
	waitForElementClickable(driver, HomePageUI.LOGIN_LINK);
	clickToElement(driver, HomePageUI.LOGIN_LINK);
	return PageGeneratorManager.getLoginPage(driver);
	}
	


	public CustomerPageObject clickToMyAccountLink() {
	waitForElementClickable(driver, HomePageUI.MY_ACCOUNT_LINK);
	clickToElement(driver, HomePageUI.MY_ACCOUNT_LINK);
	return PageGeneratorManager.getCustomerPage(driver);
	}

}
