package selfCode;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import util.BrowUtil;
import util.self_ElemenUtil;

public class domAttribute {

	static WebDriver driver;
	static String browser="chrome";
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		BrowUtil b =new BrowUtil();
		driver=b.initDriver(browser);	
		
		self_ElemenUtil e =new self_ElemenUtil(driver);		
			
		b.launchbrowser("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		
		By firstName = By.id("input-firstname");
		WebElement firstNameele=driver.findElement(firstName);
		
		e.doSendeys(firstName, "Ashwin");
		
		System.out.println(firstNameele.getDomAttribute("placeholder"));
		System.out.println(firstNameele.getDomProperty("value"));
	
//	==============================================================================
		
		By lastName = By.id("input-lastname");
//		WebElement lastNameEle = driver.findElement(lastName);		
		System.out.println(e.dogetDomAttribute(lastName, "placeholder"));
		
//		check value before and after
		System.out.println("Before-->"+e.dogetDomProperty(lastName, "value")+"<----");
		e.doSendeys(lastName, "lastNameEle");
		System.out.println("After "+e.dogetDomProperty(lastName, "value"));

		
		System.out.println(e.dogetDomProperty(lastName, "baseURI"));
		
//		System.out.println(lastNameEle.getDomProperty("baseURI"));
//		System.out.println(lastNameEle.getDomProperty("formAction"));
		
		
	}
	
//	public static String dogetDomAttribute(By locator, String attributeName ) {
//		return dogetElement(locator).getDomAttribute(attributeName);
//	}
//	
//	public static String dogetDomProperty(By locator, String attributeName ) {
//		return dogetElement(locator).getDomProperty(attributeName);
//	}
//	
//
//	public static WebElement dogetElement(By locator) {
//		return driver.findElement(locator);
//	}

}
