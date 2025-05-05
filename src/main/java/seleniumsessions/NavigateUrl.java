package seleniumsessions;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigateUrl {

	public static void main(String[] args) throws MalformedURLException {

		WebDriver driver = new ChromeDriver();//123
				
		//cntrl+shift+o
		
		
//		driver.get("https://www.google.com");//string
//		
//		driver.navigate().to("https://www.amazon.com");//string
//		driver.navigate().to(new URL("https://www.amazon.com"));//URL
		
//		URL baseUrl = new URL("https://www.flipkart.com");
//		driver.navigate().to(baseUrl);
//		
		
		
		driver.get("https://www.google.com");
		driver.get("https://www.example.com");
		driver.get("https://www.amazon.com");
		driver.get("https://www.flipkart.com");

		
		
	}

}
