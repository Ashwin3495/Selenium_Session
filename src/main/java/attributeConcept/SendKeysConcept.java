package attributeConcept;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SendKeysConcept {

	static WebDriver driver;

	public static void main(String[] args) {
		//webelement ---> sendKeys

		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		
		WebElement firstName = driver.findElement(By.id("input-firstname"));
		WebElement lastName = driver.findElement(By.id("input-lastname"));

		String FN = "Testing";
		String LN = "Automation";
		StringBuilder sb = new StringBuilder("Selenium");
		StringBuffer sbf = new StringBuffer("Learning");

		firstName.sendKeys(FN,",",LN,",",sb,",",sbf);
		
		lastName.sendKeys(null);
		
	}

}
