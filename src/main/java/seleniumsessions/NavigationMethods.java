package seleniumsessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationMethods {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.google.com");
		
		System.out.println(driver.getTitle());

		//navigate to the amazon.com
		driver.navigate().to("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		
		//driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		
		System.out.println(driver.getTitle());

		driver.navigate().back();
		
		System.out.println(driver.getTitle());

		driver.navigate().forward();
		
		System.out.println(driver.getTitle());

		driver.navigate().back();
		
		System.out.println(driver.getTitle());

		
		driver.navigate().refresh();//refresh the page

		
		
		
	}

}
