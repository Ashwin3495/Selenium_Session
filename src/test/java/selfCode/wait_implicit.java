package selfCode;

import java.time.Duration;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class wait_implicit {

	static WebDriver driver;

	public static <WebDrivetWait> void main(String[] args) {
		// TODO Auto-generated method stub

		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");

//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		String title = driver.getTitle();

		System.out.println(driver.getTitle());

		if (title.equals("Account Login")) {
			System.out.println("Pass");
		} else {
			System.out.println("fail");
		}

		driver.findElement(By.linkText("Register")).click();
		System.out.println(waitTitleContains("Register ", 5));

		driver.findElement(By.linkText("Forgotten Password")).click();
		System.out.println(waitTitleIs("Forgot Your Password?", 5));

//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//		boolean flag = wait.until(ExpectedConditions.titleIs("Account "));
//		System.out.println(flag);

//		On failure of waiting for 5 seconds it will throw TimeOut Exception
//		TimeOut happens after 5 seconds with 500 millisecond interval
//		titleIs -- will get the exact match of the title
//		titleContains -- will get the match which will have partial condition matching

//		-------------------------------------------------------------------------------------
//		URL
		System.out.println("******************URL***********************");
//		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
//		boolean flag= wait.until(ExpectedConditions.urlContains("forgotten"));
//		System.out.println(flag);

//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//		boolean flag = wait.until(ExpectedConditions
//				.urlToBe("https://naveenautomationlabs.com/opencart/index.php?route=account/forgotten"));
//		System.out.println(flag);

		System.out.println(waitUrlContains("account/forgotten",5));
		
		driver.findElement(By.linkText("Register")).click();
		System.out.println(waitUrlToBe("https://naveenautomationlabs.com/opencart/index.php?route=account/registr",5));
		
	}

	/**
	 * urlContains -- will get the match which will have partial condition
	 * matching
	 **/
	
	public static String waitUrlContains(String text, int count) {

		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(count));
			boolean flag = wait.until(ExpectedConditions.urlContains(text));
			return driver.getCurrentUrl();

		} catch (TimeoutException e) {
			return null;
		}

	}

	/**
	 * urlToBe -- will get the match which will have exact url matching
	 **/
	public static String waitUrlToBe(String text, int count) {

		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(count));
			boolean flag = wait.until(ExpectedConditions.urlToBe(text));
			return driver.getCurrentUrl();

		} catch (TimeoutException e) {
			return null;
		}

	}
	
	/**
	 * titleContains -- will get the match which will have partial condition
	 * matching
	 **/

	public static @Nullable String waitTitleContains(String text, int timeOut) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		try {
			wait.until(ExpectedConditions.titleContains(text));
			return driver.getTitle();

		} catch (TimeoutException e) {
			return null;
		}

	}

	/**
	 * titleIs -- will get the match which will have exact text condition matching
	 **/

	public static @Nullable String waitTitleIs(String text, int timeOut) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		try {
			wait.until(ExpectedConditions.titleIs(text));
			return driver.getTitle();

		} catch (TimeoutException e) {
			return null;
		}

	}
}