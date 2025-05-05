package seleniumsessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LaunchTest {

	public static void main(String[] args) {

		
		//v133 ---> 133.exe
		//v134 --> 133.exe
		
		//windows:
		//System.setProperty("webdriver.chrome.driver", "c:\\Users\\naveenautomationlabs\\Documents\\mydrivers\\chromedriver.exe");
		
		//mac/linux:
		//System.setProperty("webdriver.chrome.driver", "/Users/naveenautomationlabs/Documents/mydrivers/chromedriver");
		
		
//		WebDriver driver = new ChromeDriver();//123
//		driver = new FirefoxDriver();//345
//		driver = new EdgeDriver();//567
//		driver.get("https://www.google.com");//567
//		driver.quit();//567--null -- edge will be close
//		driver.quit();//exception will not be thrown, sid = null
		
		
		new ChromeDriver();
		new ChromeDriver().get("https://www.google.com");
		
	}

}
