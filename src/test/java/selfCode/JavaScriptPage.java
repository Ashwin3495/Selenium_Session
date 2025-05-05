package selfCode;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptPage {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");

		JavascriptExecutor js = (JavascriptExecutor) driver;
		String title = js.executeScript("return document.title").toString();
		System.out.println(title);

		String url = js.executeScript("return document.URL").toString();
		System.out.println(url);
//	
//// Click on the element
//		WebElement login=driver.findElement(By.linkText("Login"));
//		System.out.println(login);
//		js.executeScript("arguments[0].click()",login);
//		
//		Thread.sleep(5000);
//		WebElement register=driver.findElement(By.linkText("Register"));
//		js.executeScript("arguments[0].click()",register);
//		
//		// go backward
//		Thread.sleep(5000);
//		js.executeScript("history.go(-1)");
//		
//		//refresh
//		Thread.sleep(5000);
//		js.executeScript("history.go(0)");
//		
//		// go forward
//		Thread.sleep(5000);
//		js.executeScript("history.go(1)");

		// Generate alert message
		js.executeScript("alert('Hello Ashwin')");
		Thread.sleep(2000);
		driver.switchTo().alert().dismiss();

//	Get all the text in the page
		// return element is must
//		String innerText = js.executeScript("return document.documentElement.innerText").toString();
//		System.out.println(innerText);
//
//		String htmlText = js.executeScript("return document.documentElement.innerHTML").toString();
//		System.out.println(htmlText);

//	Scrolling of Page
		// first args - up and 2nd arg - down
//		js.executeScript("window.scrollTo(300,300)");
//		
//		Thread.sleep(2000);
//		// bottom of the page
//		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		
		
//		Scroll to the exact positon  --- Scroll INTO View		
		WebElement footerLink = driver.findElement(By.linkText("Terms & Conditions"));
		js.executeScript("arguments[0].scrollIntoView(true)",footerLink);
	
		
//		Highlight the ID
		js.executeScript("arguments[0].style.border='2px solid red'", footerLink);

//	SendKeys - INput text
		js.executeScript("document.getElementById('input-password').value='Test@123'");
		
//		Zoom Percentage
		js.executeScript("document.body.style.zoom='50%'");
		
	}
}
