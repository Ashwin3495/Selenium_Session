package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPageTest {

	public static void main(String[] args) {

		BrowserUtil brUtil = new BrowserUtil();
		WebDriver driver = brUtil.initDriver("chrome");
		
		brUtil.launchURL("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		
		System.out.println(brUtil.getPageTitle());

		By emailField = By.id("input-email");
		By pwdField = By.id("input-password");
		
		ElementUtil eleUtil = new ElementUtil(driver);
		
		eleUtil.doSendKeys(emailField, "tom@gmail.com");
		eleUtil.doSendKeys(pwdField, "tom@123");
		
		brUtil.quitBrowser();
		
	}

}
