package seleniumrc;

import com.thoughtworks.selenium.DefaultSelenium;
import com.thoughtworks.selenium.Selenium;

public class Verify_spicejet {
	DefaultSelenium selenium = new DefaultSelenium("localhost", 4444, "*firefox", "http://www.spicejet.com");
	public void openUrl(){
		selenium.start();
		selenium.open("/");
		selenium.windowMaximize();
		//selenium.waitForPageToLoad("30000");
	}
		public void onewayVerify() throws Exception{
		selenium.click("ctl00_mainContent_rbtnl_Trip_1");
		selenium.click("ctl00_mainContent_ddl_originStation1_CTXT");
		selenium.click("link=Hyderabad (HYD)");
		Thread.sleep(3000);
		selenium.click("link=Bengaluru (BLR)");
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Verify_spicejet s = new Verify_spicejet();
		s.openUrl();
		s.onewayVerify();

	}

}
