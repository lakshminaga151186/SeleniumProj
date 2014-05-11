package corejava;

import com.thoughtworks.selenium.DefaultSelenium;

public class Fb_Login_Ie {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DefaultSelenium log = new DefaultSelenium("localhost", 4444,
				"*firefox", "https://www.facebook.com/");
		log.start();
		log.setTimeout("12000000000000000");
		log.open("/");
		log.windowMaximize();
		log.type("email", "9966658692");
		log.type("pass", "chinnu999");
		log.click("//input[@type='submit']");
	}

}
