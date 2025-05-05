package selfCode;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import util.BrowUtil;
import util.self_ElemenUtil;

public class isElementDisplayed {
	static WebDriver driver;

	public static void main(String[] args) {

		BrowUtil b = new BrowUtil();
		driver = b.initDriver("chrome");
//		b.launchbrowser("https://seleniumpractise.blogspot.com/2016/09/how-to-work-with-disable-textbox-or.html");
		b.launchbrowser("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
	
		
		self_ElemenUtil e = new self_ElemenUtil(driver);

//		WebElement firstName = driver.findElement(By.id("fname"));
//		WebElement showme =driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]/div/div[4]/div[1]/div/div/div/div[1]/div/div/div/div[1]/div[2]/div[1]/form/input[4]"));
//		
//		boolean b1=firstName.isDisplayed();
//		boolean b2=firstName.isEnabled();
//		firstName.click();
//		boolean b3=firstName.isSelected();
//		
//		System.out.println(b1+" "+b2+" "+b3);

		By privacyCheckBox = By.name("agree");
		By firstName = By.id("input-firstname");

		System.out.println(e.isElementDisplayed(firstName));
		System.out.println(e.isElementEnabled(firstName));
		
		System.out.println(e.isElementDisplayed(privacyCheckBox));
		System.out.println(e.isElementEnabled(privacyCheckBox));
		
		System.out.println("----------------------isSelected--------------------");
		System.out.println(e.isElementSelected(privacyCheckBox)); // false

		e.doClick(privacyCheckBox);

		System.out.println(e.isElementSelected(privacyCheckBox)); // true

		System.out.println("--------------------isElementDisplayed Parameterized-----------------");
		
		b.launchbrowser("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		
		By forgotPassword = By.linkText("Forgotten Password");
		
		if(e.checkIsElementDisplayed(forgotPassword,2)) {
			System.out.println("Found 2 element present");
		}else {
			System.out.println("Element not found");
		}
		
		
	}

//	public static boolean checkIsElementDisplayed(By locator, int expectedCount) {
//		if(getElements(locator).size()==expectedCount) {
//			System.out.println("element : " + locator + " is displayed on the page " + expectedCount + " times");
//			return true;
//		}
//		return false;
//	}
	
//	public static List<WebElement> getElements(By locator) {
//		return driver.findElements(locator);
//	}
	
}
