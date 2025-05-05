package selfCode;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class wait_WindowClose {

	static WebDriver driver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		driver = new ChromeDriver();
		driver.get("https://demoqa.com/browser-windows");

		WebElement wb = driver.findElement(By.xpath("//button[@id='windowButton']"));
		wb.click();

		if (waitforWindows(2, 5)) {
			Set<String> windows = driver.getWindowHandles();
			Iterator<String> it = windows.iterator();

			String parentwindow = it.next();
			System.out.println(parentwindow);

			String childwindow = it.next();
			System.out.println(childwindow + " : " + driver.getTitle());

			driver.switchTo().window(childwindow);
			driver.close();

			driver.switchTo().window(parentwindow);
			System.out.println(parentwindow + " : " + driver.getTitle());
		}
	}

	public static boolean waitforWindows(int expectedWindows, int time) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
		try {
			return wait.until(ExpectedConditions.numberOfWindowsToBe(expectedWindows));
		} catch (Exception e) {
			System.out.println(" expected windows are not correct");
			return false;
		}

	}

}