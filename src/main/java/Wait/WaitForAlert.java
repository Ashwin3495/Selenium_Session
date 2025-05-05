package Wait;


import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitForAlert {
	static WebDriver driver;
	public static void main(String[] args) {
		driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
		
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
//		System.out.println(alert.getText());
//		alert.accept();

//		acceptAlert(5);
		sendKeysAlert(3,"ABS");
		acceptAlert(2);
	}
	
	
	public static Alert waitForAlert(int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.alertIsPresent());
	}
	
	public static void acceptAlert(int timeOut) {
		waitForAlert(timeOut).accept();
	}
	
	public static void dismissAlert(int timeOut) {
		waitForAlert(timeOut).dismiss();
	}
	
	public static void getTextAlert(int timeOut) {
		waitForAlert(timeOut).getText();
	}
	
	// iF accept is not passed it will not run
	public static void sendKeysAlert(int timeOut, String value) {
		waitForAlert(timeOut).sendKeys(value);
//		acceptAlert(2);
	}
	

}
