package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebElementConcept {

	static WebDriver driver;

	public static void main(String[] args) {

		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");

		// create a webelement(FE) + perform action(click, sendKeys,
		// isDisplayed,getText..)

		// 1.
//		driver.findElement(By.id("input-email")).sendKeys("tom@gmail.com");
//		driver.findElement(By.id("input-password")).sendKeys("tom@123");

		// 2.
//		WebElement email = driver.findElement(By.id("input-email"));
//		WebElement password = driver.findElement(By.id("input-password"));
//		
//		email.sendKeys("tom@gmail.com");
//		password.sendKeys("tom@123");

		// 3. By locator: OR
//		By emailField = By.id("input-email");
//		By pwdField = By.id("input-password");
//
//		WebElement email = driver.findElement(emailField);
//		WebElement password = driver.findElement(pwdField);
//		
//		email.sendKeys("tom@gmail.com");
//		password.sendKeys("tom@123");

		// 4. By locator + generic function to get the element.
//		By emailField = By.id("input-email");
//		By pwdField = By.id("input-password");
//		
//		getElement(emailField).sendKeys("tom@gmail.com");
//		getElement(pwdField).sendKeys("tom@123");

		// 5. By locator + generic function to get the element and perform action
//		By emailField = By.id("input-email");
//		By pwdField = By.id("input-password");
//		
//		doSendKeys(emailField, "tom@gmail.com");
//		doSendKeys(pwdField, "tom@123");

		// 6. By locator + generic function to get the element and perform action -
		// ElementUtil
		By emailField = By.id("input-email");
		By pwdField = By.id("input-password");

		ElementUtil elUtil = new ElementUtil(driver);
		elUtil.doSendKeys(emailField, "tom@gmail.com");
		elUtil.doSendKeys(pwdField, "tom@123");

		// 7. BrUtil + eleUtil --> we+action

	}

//	public static void doSendKeys(By locator, String value) {
//		getElement(locator).sendKeys(value);
//	}
//
//	public static WebElement getElement(By locator) {
//		return driver.findElement(locator);	
//	}

}
