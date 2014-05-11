package corejava;

import com.thoughtworks.selenium.DefaultSelenium;

public class Gmail_Login {
 
	public static void main(String[] arg){
		DefaultSelenium log = new DefaultSelenium("localhost", 4444, "*firefox", "https://mail.google.com");
		log.start();
		log.open("/");
		log.windowMaximize();
		log.type("Email", "lakshminaga151186");
		log.type("Passwd", "chinnumechanical");
		log.click("signIn");
	}
}
