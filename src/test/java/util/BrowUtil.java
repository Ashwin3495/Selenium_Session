package util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import seleniumsessions.BrowserException;

public class BrowUtil {
	private WebDriver driver;

	/**
	 * 
	 * @param browsername
	 * @return
	 */
	public WebDriver initDriver(String browsername)  {
		switch (browsername.toLowerCase().trim()) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;

		default:
			System.out.println("Insert correct driver name"+browsername);
			throw new BrowserException("============= INVALID BROWSER =====================");
			
		}
		return driver;
	}

	public void launchbrowser(String url) {
		nullCheck(url);
		lengthCheck(url);
		httpCheck(url);
		driver.get(url);
		
	}
	
	public String getPageTitle() {
		String title=driver.getTitle();
//		System.out.println(title);
		return title;
	}

	public String getPageUrl() {
		String url=driver.getCurrentUrl();
		return url;
	}
	
	public void quit() {
		if(driver!=null) {
		driver.quit();
	}
		System.out.println("Browser Quit");
	}
	
//	============================PRIVATE ==========================================
	private void nullCheck(String value) {
		if(value==null) {
			System.out.println("Do not pass null value!!!");
			throw new BrowserException("============== Value is Null =================");
		}		
//		return value;
	}
	
	private String lengthCheck(String value) {
		if(value.length()==0) {
			System.out.println("Value is 0");
			throw new BrowserException("=========== Length is 0 =============");
		}
		return value;
	}
	
	private String httpCheck(String value) {
		if(value.indexOf("http")!=0) {
			System.out.println("=============== Http not present in url ===================");
		}
		return value;
	}
	
	
}
