package attributeConcept;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ElementDisplayed {

	static WebDriver driver;

	public static void main(String[] args) {
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");

//		WebElement firstName = driver.findElement(By.id("input-firstname11"));
//		
//		boolean b1 = firstName.isDisplayed();	
//		System.out.println(b1);

//		boolean b1 = driver.findElement(By.id("input-firstname11")).isDisplayed();
//		System.out.println(b1);

		By fn = By.id("input-firstname");
		
		if (isElementDisplayed(fn)) {
			System.out.println("ele is displayed - PASS");
		} else {
			System.out.println("ele is not displayed - FAIL");
		}
		
		
		By logo = By.className("img-responsive");
		System.out.println(isElementDisplayed(logo));
		
	}

	public static boolean isElementDisplayed(By locator) {
		try {
			return getElement(locator).isDisplayed();
		} 
		catch (NoSuchElementException e) {
			System.out.println("element is not present on the page using : " + locator);
			return false;
		}

	}

	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

}
