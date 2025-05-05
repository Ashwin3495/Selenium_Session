package seleniumsessions;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class TopCastingOptions {

	public static void main(String[] args) {

		//1. CD = CD only chrome
		//ChromeDriver driver = new ChromeDriver();
		
		//2. WD d = new CD
		//valid and recommended
		//only for local execution
		//WebDriver driver = new ChromeDriver();
		
		
		//3. SC d = new CD();
		//valid but not recommended
		//SearchContext driver = new ChromeDriver();
		
		//4. WD d = new RWD();
		//valid and recommended: remote execution
		//used when we want to run test cases in remote machine, cloud, AWS, grid, VM
		//WebDriver driver = new RemoteWebDriver(remoteAddress, capabilities);//os/browser
		
		//5. SC d = new RWD();
		//valid but not recommended
		//SearchContext driver = new RemoteWebDriver(remoteAddress, capabilities);
		
		
		//6. RWD d = new CD();
		//local
		//valid and recommended
		//RemoteWebDriver driver = new ChromeDriver();
		
		//7. Chromium d = new CD();
		//local
		//valid and not recommended: works only for chromium based browser: chrome/edge
//		ChromiumDriver driver = new ChromeDriver();
//		driver = new EdgeDriver();
		
		//8. RWD d = RWD
		//valid but only for remote execution
		//RemoteWebDriver driver = new RemoteWebDriver(new URL("192.178.11.2:4444/wd/hub"), capabilities);//os/browser
		
		
	}

}
