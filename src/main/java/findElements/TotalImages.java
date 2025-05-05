package findElements;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TotalImages {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.com/");
		
		List<WebElement> imagesList = driver.findElements(By.tagName("img"));
		
		System.out.println("total images:" + imagesList.size());
		
		for(WebElement e : imagesList) {
			//web scraping
			String altVal = e.getDomAttribute("alt");
			String srcVal = e.getDomAttribute("src");
			
			System.out.println(altVal + " : " + srcVal);
		}
		
		
	}

}
