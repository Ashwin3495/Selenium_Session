package selfCode;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class wait_frame {

	static WebDriver driver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		driver = new ChromeDriver();
		driver.get("https://www.formsite.com/templates/registration-form-templates/vehicle-registration-form/");// page

		By image = By.xpath("//img[@title='Vehicle-Registration-Forms-and-Examples']");
		By frame = By.xpath("//iframe[contains(@id,'frame')]");  // By locator
		WebElement iframe = driver.findElement(By.xpath("//div[@id='formTemplateContainer']/iframe"));		//WebElement
		
		By title = By.id("RESULT_TextField-1");		
		 
		By Preview = By.className("details__form-preview-title");
		
		driver.findElement(image).click();

		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(frame));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iframe));
		
		driver.findElement(title).sendKeys("Ashoio");
		
		driver.switchTo().defaultContent();
		
		System.out.println(driver.findElement(Preview).getText());
		
	}
	
	public static void waitForFrameToSwitch(By locator, int time) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));
	}
	
	public static void waitForFrameToSwitch(WebElement locator, int time) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));
	}
	
	public static void waitForFrameToSwitch(String name, int time) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(name));
	}
	
	public static void waitForFrameToSwitch(int frameIndex, int time) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameIndex));
	}

}
