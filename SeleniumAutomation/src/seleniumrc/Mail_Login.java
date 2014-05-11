package seleniumrc;

import com.thoughtworks.selenium.DefaultSelenium;

public class Mail_Login {
private DefaultSelenium	selenium=new DefaultSelenium("localhost", 4444, "*firefox", "http://mail.in.com");
	public void openURL(){
		selenium.start();
		selenium.open("/");
		selenium.windowMaximize();		
	}
	public void login() {
		selenium.type("f_id", "jan30selenium");
		selenium.type("f_pwd", "selenium1");
		selenium.click("css=input.signin");	
		selenium.waitForPageToLoad("3000000000000000000000"); //30sec
		selenium.windowFocus();	
	}
	public void logout(){
		selenium.click("link=Sign out");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Mail_Login m=new Mail_Login();
		m.openURL();
		m.login();
		m.logout();

	}

}