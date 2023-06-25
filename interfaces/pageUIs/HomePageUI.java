package pageUIs;

public class HomePageUI {
		// Biến: Variable/ Property
		//public static final String REGISTER_LINK = "//a[@class='ico-register']";
	
		// public: Truy cập từ các class bên ngoài package theo cách thông thư
		// private: Các class bên ngoài ko truy cập vào được
		// default: Các class bên ngoài khác package cũng ko truy cập được
		// protected: Bắt buộc phải kế thừa mới truy cập được
	
		// static: Có thể truy cập trực tiếp từ phạm vi Class - chứ ko cần phạm vi từ instance
	
		// final: Không cho phép ghi đè lên biến này nữa
		// Ngăn cản việc gán lại thành 1 element khác
	
		// String: Các By locator đều nhận tham số vào là String
	
		// Tên biến: static + final (Mặc định đây là hằng số - Constant)
		// In đậm + In nghiêng
		// Hằng số trong Java: Bắt buộc viết hoa và phân tách bởi gạch nối _ (Convention)
	
		// Giá trị: Nằm trong dấu nháy đôi "
		// Cú pháp XPath

	public static final String REGISTER_LINK ="//a[@class='ico-register']";
	public static final String LOGIN_LINK ="//a[@class='ico-login']";
	public static final String MY_ACCOUNT_LINK="//a[@class='ico-account']";

}
