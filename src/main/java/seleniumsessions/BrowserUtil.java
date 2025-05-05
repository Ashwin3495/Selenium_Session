package seleniumsessions;

import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

/**
 * 
 * @author naveenautomationlabs
 *
 */
public class BrowserUtil {

	private WebDriver driver;

	/**
	 * this is used to init the driver on the basis of given browser name: chrome,
	 * firefox, edge, safari
	 * 
	 * @param browserName
	 * @return it returns the driver
	 */
	public WebDriver initDriver(String browserName) {
		System.out.println("browser name:" + browserName);
		
		switch (browserName.trim().toLowerCase()) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
		case "safari":
			driver = new SafariDriver();
			break;

		default:
			System.out.println("plz pass the right browser name..." + browserName);
			throw new BrowserException("===INVALID BROWSER===");
		}
		return driver;
	}

	// https://www.google.com
	public void launchURL(String url) {
		nullCheck(url);
		lengthCheck(url);
		httpCheck(url);
		driver.get(url);
	}

	public void launchURL(URL url) {
		String appUrl = String.valueOf(url);
		nullCheck(appUrl);
		lengthCheck(appUrl);
		httpCheck(appUrl);
		driver.navigate().to(url);
	}

	public String getPageTitle() {
		String title = driver.getTitle();
		System.out.println("page title is: " + title);
		return title;
	}

	public String getPageURL() {
		String pageURL = driver.getCurrentUrl();
		System.out.println("page URL is: " + pageURL);
		return pageURL;
	}

	public void closeBrowser() {
		if (driver != null) {
			driver.close();
			System.out.println("browser is closed");
		}
	}

	public void quitBrowser() {
		if (driver != null) {
			driver.quit();
			System.out.println("browser is closed");
		}
	}

	private void lengthCheck(String value) {
		if (value.length() == 0) {
			System.out.println("value can not be blank..." + value);
			throw new BrowserException("===Empty value===");
		}
	}
	
	private void nullCheck(String value) {
		if (value == null) {
			System.out.println("value can not be null..." + value);
			throw new BrowserException("===value is null===");
		}
	}

	private void httpCheck(String urlValue) {
		if (urlValue.indexOf("http") != 0) {
			System.out.println("http is missing in the url..." + urlValue);
			throw new BrowserException("===http is missing===");
		}
	}

}
