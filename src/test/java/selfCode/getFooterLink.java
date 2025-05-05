package selfCode;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import util.BrowUtil;
import util.self_ElemenUtil;

public class getFooterLink {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		BrowUtil b = new BrowUtil();
		driver = b.initDriver("chrome"); // Important step or else ElemenUtil wont work

		self_ElemenUtil e = new self_ElemenUtil(driver);
		b.launchbrowser("https://naveenautomationlabs.com/opencart/index.php?route=account/login");

		By footerlink = By.xpath("//footer//li/a");
		e.clickOnElement(footerlink,"Delivery Information");
		Thread.sleep(3000);
		clickOnElement(footerlink, "Gift Certificates");
		
//		It can only return value but wont click
//		for (String el : e.getElementTextList(footerlink)) {
//			System.out.println(el);
//			if (el.contains("Order History")) {
//				e.doClick(footerlink); // this wont work it requires exact locator id where as we have list of element
//				break;
//			}
//		}

	}

	public static void clickOnElement(By locator, String value) {
		List<WebElement> wlist = getfindElements(locator);
		System.out.println("Total elements : "+wlist.size());
		for (WebElement e : wlist) {
			String text = e.getText();
			System.out.println(text);
			if (text.contains(value)) {
				e.click();
				break;
			}
		}
		
	}

	public static List<WebElement> getfindElements(By locator) {
		return driver.findElements(locator);
	}

}
