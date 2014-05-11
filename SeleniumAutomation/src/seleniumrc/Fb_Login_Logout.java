package seleniumrc;

import com.thoughtworks.selenium.DefaultSelenium;

public class Fb_Login_Logout {
	DefaultSelenium sel = new DefaultSelenium("localhost", 4444, "*firefox", "http://www.facebook.com");
	public void openURL(){
		sel.start();
		sel.open("/");
		sel.waitForPageToLoad("30000");
		sel.windowMaximize();
	}
	public void login() throws Exception{
		sel.type("email", "9966658692");
		sel.type("pass", "chinnu999");
		Thread.sleep(2000);
		sel.click("//input[@type='submit']");
		sel.waitForPageToLoad("3000000000");
		//Thread.sleep(5000);
			}
	public void logout() throws Exception {
		sel.click("//a[@id='navAccountLink']/div");
		Thread.sleep(2000);
		//sel.waitForPageToLoad("30000");
		sel.click("css=input.uiLinkButtonInput");		
	}
public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
 Fb_Login_Logout m = new Fb_Login_Logout();
 	m.openURL();
 	m.login();
 	m.logout();
	}

}
