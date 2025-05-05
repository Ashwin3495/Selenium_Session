package selfCode;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import util.BrowUtil;
import util.self_ElemenUtil;

public class total_menu {

	static WebDriver driver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BrowUtil b = new BrowUtil();
		driver = b.initDriver("chrome");

		self_ElemenUtil ele = new self_ElemenUtil(driver);

		b.launchbrowser("https://naveenautomationlabs.com/opencart/index.php?route=account/login");

		// --------------- Menu List -----------------
		By menuList = By.className("list-group-item");
		List<WebElement> mList = driver.findElements(menuList);
		int mSize = mList.size();

		for (int i = 0; i > mList.size() - 1; i++) {

//			System.out.println(mList.get(i).getText());

			String text = mList.get(i).getText();

			if (text.length() != 0) {
				System.out.println(text);
			}
		}

//		Same as above - for each loop
		for (WebElement e : mList) {
			String text = e.getText();
			if (text.length() != 0) {
				System.out.println(text);
			}
		}
//			Verify the count
		if (mSize == 13) {
			System.out.println("Correct 13");
		} else {
			System.out.println("Link missings");
		}

//		------------------------------ getElement List ------------------------
		System.out.println("----------------------- getElement List ---------------");

		
		for(String e:ele.getElementTextList(menuList)) {
			System.out.println(e);
		}
		

		if (ele.getCount(menuList) == 13) {
			System.out.println("Element count ->" + ele.getCount(menuList));

		}
		
//		------------------------------------------------------
	}

//	public static List<String> getElementTextList(By locator) {
//		List<WebElement> wlist = getElement(locator);
//		List<String> elist = new ArrayList<String>();
//		for(WebElement e : wlist) {
//			String text=e.getText();
//			if(text.length()!=0) {
//				System.out.println(text);
//				elist.add(text);
//			}
//		}
//		return elist;
//	}
//	
//	public static int getCount(By locator){
//		return getElement(locator).size();
//	}
//	
//	public static List<WebElement> getElement(By locator){
//		return driver.findElements(locator);
//	}

}
