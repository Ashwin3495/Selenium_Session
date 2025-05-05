package Wait;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitForWindow {

	static WebDriver driver;

	public static void main(String[] args) {

		driver = new ChromeDriver();

		driver.get("https://www.orangehrm.com/30-day-free-trial");// parent
		driver.manage().window().maximize();

		Actions act = new Actions(driver);
		act.sendKeys(Keys.PAGE_DOWN).perform();

		WebElement fb_ele = driver.findElement(By.xpath("//img[@alt='facebook logo']"));
		fb_ele.click();
		
//		driver.get("https://demoqa.com/browser-windows");
//		driver.manage().window().fullscreen();
//
//		WebElement window= driver.findElement(By.xpath("//button[@id='windowButton']"));
//		window.click();

//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//		wait.until(ExpectedConditions.numberOfWindowsToBe(2));

		if (waitForWindow(2, 5)) {

			// 1.get the window ids
			Set<String> handles = driver.getWindowHandles();
			Iterator<String> it = handles.iterator();

			String parentWindowID = it.next();
			System.out.println("parent window id: " + parentWindowID);

			String childWindowID = it.next();
			System.out.println("child window id: " + childWindowID);

			// 2nd: switching work:
			driver.switchTo().window(childWindowID);
			System.out.println("child window title : " + driver.getTitle());

			// close the child window:
			driver.close();

			// driver is lost:

			// switch back to parent window:
			driver.switchTo().window(parentWindowID);
			System.out.println("parent window title : " + driver.getTitle());

		}
	}

	public static boolean waitForWindow(int expectedNumberOfWindows, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));

		try {
			return wait.until(ExpectedConditions.numberOfWindowsToBe(expectedNumberOfWindows));
		} catch (Exception e) {
			System.out.println("expectedNumberOfWindows are not correct");
			return false;
		}

	}

}
