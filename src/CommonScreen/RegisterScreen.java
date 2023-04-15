package CommonScreen;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Common.Constant;
import Common.Utilities;

public class RegisterScreen {
	// Text field
	public static String phoneTxtID				= "phone-number";
	
	// Button
	public static String registerBtnXpath		= "//span[contains(text(),'ĐĂNG KÝ')]";
	
	// Error message 
	public static String errorMsgXpath 			= "//div[@class='error-mesage']//ul//li";
	
	// List of messages
	public static String emptyPhoneMsg			= "Lỗi: Vui lòng nhập các trường bắt buộc (*).";
	public static String invalidPhoneMsg		= "Số điện thoại không hợp lệ, vui lòng thử lại.";
	
	public static WebDriver openScreen(String browser) {
		WebDriver driver = null;
		if (!browser.isEmpty()) {
			driver = Utilities.getDriver(browser);
			driver.get(Constant.BASE_URL);
			Utilities.clickObscuredElement(driver, HomeScreen.registerLinkXpath, registerBtnXpath, Constant.WAIT_ELEMENT_EXIST);
		}
		return driver;
	}
	
	public static void register(WebDriver driver, String phone, String expectErrMsg) {
		Utilities.waitForElementVisibility(driver, By.id(phoneTxtID));
		Utilities.inputValueAndValidate(driver, By.id(phoneTxtID), phone, phone.replace(" ", ""));	
		if (expectErrMsg == "") {
			Utilities.clickObscuredElement(driver, By.xpath(registerBtnXpath), By.xpath(UpdateAccountScreen.titleScreenXpath), 
					Constant.WAIT_ELEMENT_EXIST*3);
		}
		else {
			Utilities.clickObscuredElement(driver, By.xpath(registerBtnXpath), By.xpath(errorMsgXpath), 
					Constant.WAIT_ELEMENT_EXIST*3);
			Utilities.assertTextValue(driver, By.xpath(errorMsgXpath), expectErrMsg);
		}
	}	
}
