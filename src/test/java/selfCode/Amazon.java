package selfCode;

import util.BrowUtil;

public class Amazon {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String browser = "chrome";
		BrowUtil c = new BrowUtil();
		c.initDriver(browser);

		System.out.println("browser :"+browser);		
		c.launchbrowser("https://www.amazon.in/ref=nav_logo");
		
		


		if (c.getPageTitle().contains("Amazon")) {
			System.out.println("===============Title pass=================");
		} else {
			System.out.println("===============Title fail=================");
		}
		
		String url=c.getPageUrl();
		if(url.contains("/ref=nav_logo")) {
			System.out.println("================= URL pass ===================");
		}else {
			System.out.println("================== URL not matched ======================");
		}
		
		c.quit();
	}

}
