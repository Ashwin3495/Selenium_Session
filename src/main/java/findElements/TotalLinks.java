package findElements;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TotalLinks {

	public static void main(String[] args) {

		// find total number of links on the page
		// print the text of each link on the console if text is not empty
		// html tag = <a>

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		
		By links = By.tagName("a");
		
		ElementUtil elUtil = new ElementUtil(driver);
		
		if(elUtil.getElementsCount(links) > 300) {
			System.out.println("proper links are present -- PASS");
		}
		
		List<String> linksTextList = elUtil.getElementTextList(links);
		if(linksTextList.contains("Corporate Information")) {
			System.out.println("PASS");
		}
		

//		List<WebElement> linksList = driver.findElements(By.tagName("a"));
//
//		System.out.println("total links:" + linksList.size());
//
//		// index loop:
//		for (int i = 0; i < linksList.size(); i++) {
//			String text = linksList.get(i).getText();
//			if (text.length() != 0) {
//				System.out.println(text);
//			}
//		}
//
//		System.out.println("-----------------");
//
//		for (WebElement e : linksList) {
//			String text = e.getText();
//			if (text.length() != 0) {
//				System.out.println(text);
//			}
//		}

	}

}
