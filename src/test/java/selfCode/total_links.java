package selfCode;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import util.BrowUtil;
import util.self_ElemenUtil;

public class total_links {

	static WebDriver driver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BrowUtil b = new BrowUtil();
		driver=b.initDriver("chrome");

		self_ElemenUtil el = new self_ElemenUtil(driver);

		b.launchbrowser("https://www.flipkart.com/");
		
		By link = By.tagName("a");
		By image = By.tagName("img");
		
		el.getElementTextList(image);
		
		
		System.out.println(el.getCount(image));
		
//		Get the Image name and url
		
		for(String e : el.getImageName(image)) {
			System.out.println(e);
		}
		
//		for(WebElement e : el.getElements(image)) {
//			//web scraping
//			String altVal = e.getDomAttribute("alt");
//			String srcVal = e.getDomAttribute("src");
//			
//			System.out.println(altVal + " : " + srcVal);
//		}
		
		
//		if(e.getCount(link)>300) {
//			System.out.println("Link count greater than 300 ->"+e.getCount(link));
//		}else {
//			System.out.println("Incorrect website");
//		}
//		
//		System.out.println(e.getElementTextList(link).size());
//		
//		List<String> linksTextList = e.getElementTextList(link);
//		if(linksTextList.contains("Corporate Information")) {
//			System.out.println("PASS");
//			
//		}
		
		
	}
	

}
