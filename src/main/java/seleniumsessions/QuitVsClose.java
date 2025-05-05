package seleniumsessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class QuitVsClose {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();//123

		driver.get("https://www.google.com");//123

		String title = driver.getTitle();//123
		System.out.println(title);

		String url = driver.getCurrentUrl();//123
		System.out.println(url);

		//driver.quit();//123
		driver.close();//sid=123
		
		//sid=null in case of quit
		
		//System.out.println(driver.getTitle());//sid=123--invalid
		
		driver = new ChromeDriver();//456
		driver.get("https://www.google.com");//456
		System.out.println(driver.getTitle());//456
		
		
	}

}
