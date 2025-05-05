package selfCode;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import util.BrowUtil;
import util.self_ElemenUtil;

public class Registration {

	static WebDriver driver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String browser = "chrome";
		System.out.println("browser :"+browser);
		
		BrowUtil bu = new BrowUtil();
		driver = bu.initDriver(browser); // driver - since initDriver is return driver it needs to stored and
											// then use in ElemenUtil
		bu.launchbrowser("https://naveenautomationlabs.com/opencart/index.php?route=account/register");	
		

		By FirstName = By.id("input-firstname");
		By LastName = By.id("input-lastname");
		By Email = By.id("input-email");
		By Telephone = By.id("input-telephone");
		By Password = By.id("input-password");
		By Confirmpwd = By.id("input-confirm");
		By Agree = By.name("agree");
		By Continue = By.xpath("//*[@id='content']/form/div/div/input[2]");
		By title = By.tagName("h1");
		By logout = By.linkText("Logout");
		
		
		self_ElemenUtil eleu = new self_ElemenUtil(driver);
		eleu.doSendeys(FirstName, "Ashwin");
		eleu.doSendeys(LastName, "Yadav");
		eleu.doSendeys(Email, "ashwin5@gmail.com");
		eleu.doSendeys(Telephone, "9930361670");
		eleu.doSendeys(Password, "Ashwin123#");
		eleu.doSendeys(Confirmpwd, "Ashwin123#");
		eleu.doClick(Agree);
		eleu.doClick(Continue);

		String header = eleu.doGetText(title);
		System.out.println("Title of the page :"+header);
		if (header.equals("Your Account Has Been Created!")) {
			System.out.println("Account created -- Title pass");
		} else {
			System.out.println("Account creation failed");
		}

		String Account_Creation=bu.getPageUrl();
		System.out.println("Title of the page :"+Account_Creation);
		if(Account_Creation.contains("account/success")) {
			System.out.println("Correct page url -- Success");
		}else {
			System.out.println("Wrong page -- Fail");
		}
		
		eleu.doClick(logout);
		
		String Account_Logout=bu.getPageUrl();
		System.out.println("Title of the page :"+Account_Logout);
		if(Account_Logout.contains("account/logout")) {
			System.out.println("Logout success");
		}else {
			System.out.println("Logout Failed");
		}
				
		bu.quit();
	}

}
