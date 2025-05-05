package selfCode;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class findElements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// find total number of link in a page
		// print eachlink
		// html tag <a>

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");

		// No action can be performed // Return type is List // List will maintain the
		// order // Not using static because value will be dynamic

		List<WebElement> linkList = driver.findElements(By.tagName("a"));

		System.out.println(linkList.size());

		// Print the linklist // index loop // Check if the link is non-empty

		for (int i = 0; i < linkList.size(); i++) {
			String text = linkList.get(i).getText();
//			 return WebElement 
			if (text.length() != 0) {
				System.out.println(i + " : " + text);
			}
		}
		System.out.println("============== FOR EACH LOOP ===============");

		for (WebElement elist : linkList) {
			String etext = elist.getText();
			if (etext.length() != 0) {
				System.out.println(etext);
			}

		}

		System.out.println("===================ImG================");

		List<WebElement> imageList = driver.findElements(By.tagName("img"));
		System.out.println("total images :" + imageList.size());

		// Web Scrapping - Getting the information on the site

		for (WebElement e : imageList) {
			String altVal = e.getDomAttribute("alt");
			String srcVal = e.getDomAttribute("src");

			System.out.println(altVal + " " + srcVal);
		}

		System.out.println("==================Link list======================");

		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		List<WebElement> menuList = driver.findElements(By.className("list-group-item"));

		System.out.println(menuList.size());

		for (WebElement mList : menuList) {
			String e = mList.getText();
			System.out.println(e);
			if (e.equals("Forgotten Password")) {
				mList.click();
				break;
			}
		}

	}
}
