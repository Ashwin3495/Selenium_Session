package attributeConcept;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetTextFieldText {

	static WebDriver driver;

	public static void main(String[] args) {

		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		
		WebElement emailIDEle = driver.findElement(By.id("input-email"));
		
		emailIDEle.sendKeys("pop@selenium.com");
		
		String emailID = emailIDEle.getDomProperty("value");
		System.out.println(emailID);
		
		//DOm attr
		//dom Prop
		
		
	}

}
