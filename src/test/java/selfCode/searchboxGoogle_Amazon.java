package selfCode;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import util.BrowUtil;
import util.self_ElemenUtil;

public class searchboxGoogle_Amazon {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		BrowUtil b = new BrowUtil();
		driver = b.initDriver("chrome");

		self_ElemenUtil eu= new self_ElemenUtil(driver);
		
		
//		-------------------------------- Amazon search box --------------------
		b.launchbrowser("https://www.amazon.com");
		
		By searcha=By.id("twotabsearchtextbox");
		Thread.sleep(10000);
		eu.doSendeys(searcha, "led tv");
		
		By selectSearch = By.xpath("//div[@class='s-suggestion s-suggestion-ellipsis-direction']");
		Thread.sleep(3000);
		eu.clickOnElement(selectSearch, " cleaner");
		
/*

//		---------------------------Google search box ---------------------------
		b.launchbrowser("https://www.google.com");
		
		By search = By.xpath("//textarea[@class='gLFyf']");
		eu.doSendeys(search, "testing jobs");
		
		Thread.sleep(2000);
		
		By list = By.xpath("//div[@class='wM6W7d']/span");
		
//		------------------------Util class --------------------------
		System.out.println(eu.getElementTextList(list));
		eu.clickOnElement(list, "mumbai");
		
		
//		-------------------------------- Logic -------------------------------------
		List<WebElement> searchlist = eu.getElements(list);
		
		
		for(WebElement e : searchlist) {
			String text = e.getText();
			if(text.contains("mumbai")) {
				e.click();
				break;
			}
		}
		*/
		
	}

}
