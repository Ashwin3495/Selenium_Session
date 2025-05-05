package util;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class self_ElemenUtil {
	private WebDriver driver;

//	Private variable for checking null value
	private void nullCheck(CharSequence... value) {
		if (value == null) {
			throw new RuntimeException("===Value can not be null===");
		}
	}

//	Initialize the driver
	public self_ElemenUtil(WebDriver driver) {
		this.driver = driver;
	}

//	sendkeys
	public void doSendeys(By locator, String value) {
		nullCheck(value);
		getElement(locator).sendKeys(value);
	}

//	click on the locator
	public void doClick(By locator) {
		getElement(locator).click();
	}

//	getText from locator
	public String doGetText(By locator) {
		return getElement(locator).getText();
	}

//	----------------- Image name and source------------------

	public List<String> getImageName(By locator) {
		List<WebElement> wimg = getElements(locator);
		List<String> eimg = new ArrayList<String>();
		for (WebElement e : wimg) {
			String name = e.getDomAttribute("alt");
			String url = e.getDomAttribute("src");
			if (name != null && url != null) {
				eimg.add(name + " " + url);
//				System.out.println(name+" -> "+url);
			}
		}
		return eimg;
	}

//	------------------- List text --------------------
	public List<String> getElementTextList(By locator) {
		List<WebElement> wlist = getElements(locator);
		List<String> elist = new ArrayList<String>();
		for (WebElement e : wlist) {
			String text = e.getText();
			if (text.length() != 0) {
//				System.out.println(wlist.indexOf(e)+" -> "+ text);							// Avoid using sysout in return statement
				elist.add(text);
			}
		}
		return elist;
	}

//	------------------- get count of list ----------------
	public int getCount(By locator) {
		int size = getElements(locator).size();
		return size;
	}

//	----------------- findElements  Util-----------------------------

//	find and return list of elements
	public List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}

//	find and return single element
	public WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

//	 ----------------- DOM attributes------------------------
	public String dogetDomAttribute(By locator, String attributeName) {
		nullCheck(attributeName);
		return getElement(locator).getDomAttribute(attributeName);
	}

	public String dogetDomProperty(By locator, String attributeName) {
		nullCheck(attributeName);
		return getElement(locator).getDomProperty(attributeName);
	}

//	 -------------------- Display, Selected, Enabled--------------------------
	public boolean isElementDisplayed(By locator) {
		if (getElements(locator).size() == 1) {
			System.out.println("element : " + locator + " is displayed on the page one time");
			return getElement(locator).isDisplayed();
		}
		return false;
	}

	public boolean checkIsElementDisplayed(By locator, int expectedCount) {
		if (getElements(locator).size() == expectedCount) {
			System.out.println("element : " + locator + " is displayed on the page " + expectedCount + " times");
			return true;
		}
		return false;
	}

	public boolean isElementSelected(By locator) {
		return getElement(locator).isSelected();
	}

	public boolean isElementEnabled(By locator) {
		return getElement(locator).isEnabled();
	}

//	-------------------- Click on entered element and break --------------------------
	public void clickOnElement(By locator, String value) {
		List<WebElement> wlist = getElements(locator);
		System.out.println("total number of elements: " + wlist.size());
		for (WebElement e : wlist) {
			String text = e.getText();
			System.out.println(text);
			if (text.contains(value)) {
				e.click();
				break;
			}

		}

	}
	
//	--------------------------- Alert Wait------------------
	
	public  Alert waitForAlert(int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		return wait.until(ExpectedConditions.alertIsPresent());
	}
	
	// method accept is a void
	public  void acceptAlert(int timeout) {
		 waitForAlert(timeout).accept();
	}

	public  void dismissAlert(int timeout) {
		 waitForAlert(timeout).dismiss();
	}
	
	public  void sendKeysAlert(int timeout,String value) {
		 waitForAlert(timeout).sendKeys(value);
	}
	
	public  void getTextAlert(int timeout) {
		 waitForAlert(timeout).getText();
	}
	
	
//	------------------------- Wait Utils --------------------
	
	public  WebDriver  waitForFrameToSwitch(By locator, int time) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		return wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));
	}
	
	public  WebDriver waitForFrameToSwitch(WebElement locator, int time) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		return wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));
	}
	
	public  WebDriver waitForFrameToSwitch(String name, int time) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		return wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(name));
	}
	
	public  WebDriver waitForFrameToSwitch(int frameIndex, int time) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		return wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameIndex));
	}

	
	
	/**
	 * User must give the expected number of window and the time to wait 
	 * @param expectedWindows
	 * @param time
	 * @return
	 */
	public boolean waitforWindows(int expectedWindows, int time) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
		try {
			return wait.until(ExpectedConditions.numberOfWindowsToBe(expectedWindows));
		} catch (Exception e) {
			System.out.println(" expected windows are not correct");
			return false;
		}

	}
	
	/**
	 * urlContains -- will get the match which will have partial condition
	 * matching
	 **/
	
	public  String waitUrlContains(String text, int count) {

		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(count));
			boolean flag = wait.until(ExpectedConditions.urlContains(text));
			return driver.getCurrentUrl();

		} catch (TimeoutException e) {
			return null;
		}

	}

	/**
	 * urlToBe -- will get the match which will have exact url matching
	 **/
	public  String waitUrlToBe(String text, int count) {

		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(count));
			boolean flag = wait.until(ExpectedConditions.urlToBe(text));
			return driver.getCurrentUrl();

		} catch (TimeoutException e) {
			return null;
		}

	}
	
	/**
	 * titleContains -- will get the match which will have partial condition matching
	 **/
	
	public  @Nullable String waitTitleContains(String text, int timeOut) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		try {
			wait.until(ExpectedConditions.titleContains(text));
			return driver.getTitle();

		} catch (TimeoutException e) {
			return null;
		}

	}

	/**
	 * titleIs -- will get the match which will have exact text condition matching
	 **/
	
	public  @Nullable String waitTitleIs(String text, int timeOut) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		try {
			wait.until(ExpectedConditions.titleIs(text));
			return driver.getTitle();

		} catch (TimeoutException e) {
			return null;
		}

	}

}
