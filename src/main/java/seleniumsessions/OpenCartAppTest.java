package seleniumsessions;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;

public class OpenCartAppTest {

	public static void main(String[] args)  {

		BrowserUtil brUtil = new BrowserUtil();
		
		WebDriver driver = brUtil.initDriver("firefox");
		//brUtil.launchURL("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		
		URL url;
		try {
			url = new URL("naveenautomationlabs.com/opencart/index.php?route=account/login");
			brUtil.launchURL(url);

		} catch (MalformedURLException e) {
			System.out.println("https is missing");
			e.printStackTrace();
			throw new BrowserException("http is mising");
		}
		
		

		String actTitle = brUtil.getPageTitle();
		if(actTitle.equals("Account Login")) {
			System.out.println("title is correct -- PASS");
		}
		else {
			System.out.println("title is not correct -- FAIL");
		}
		
		String actUrl = brUtil.getPageURL();
		if(actUrl.contains("route=account/login")) {
			System.out.println("login page url is correct -- PASS");
		}
		else {
			System.out.println("login page url is correct -- FAIL");
		}
		
		brUtil.quitBrowser();
		
	}

}
