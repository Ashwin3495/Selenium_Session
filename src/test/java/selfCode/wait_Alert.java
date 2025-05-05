package selfCode;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import util.self_ElemenUtil;

public class wait_Alert {

	static WebDriver driver;

	public static void main(String[] args) {

		driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");

		self_ElemenUtil se = new self_ElemenUtil(driver);

		By JsAlert = By.xpath("//button[text()='Click for JS Alert']");
		By JsConfirm = By.xpath("//button[text()='Click for JS Confirm']");
		By JsPrompt = By.xpath("//button[text()='Click for JS Prompt']");

		se.doClick(JsAlert);
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//		wait.until(ExpectedConditions.alertIsPresent()).accept();
		
		acceptAlert(2);

		se.doClick(JsConfirm);
//		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(5));
//		System.out.println(wait1.until(ExpectedConditions.alertIsPresent()).getText());
//		wait1.until(ExpectedConditions.alertIsPresent()).accept();
		
		getTextAlert(5);
		acceptAlert(2);
		
		// The below code will work only in case if accept is added
		se.doClick(JsPrompt);
//		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(5));
//		
//		wait2.until(ExpectedConditions.alertIsPresent()).sendKeys("ASLD");
//		wait2.until(ExpectedConditions.alertIsPresent()).accept();
		
		sendKeysAlert(5,"ABC");
		acceptAlert(2);
		
	}
	
	public static Alert waitForAlert(int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		return wait.until(ExpectedConditions.alertIsPresent());
	}
	
	// method accept is a void
	public static void acceptAlert(int timeout) {
		 waitForAlert(timeout).accept();
	}

	public static void dismissAlert(int timeout) {
		 waitForAlert(timeout).dismiss();
	}
	
	public static void sendKeysAlert(int timeout,String value) {
		 waitForAlert(timeout).sendKeys(value);
	}
	
	public static void getTextAlert(int timeout) {
		 waitForAlert(timeout).getText();
	}
	
}
