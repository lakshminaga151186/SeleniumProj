package corejava;

import com.thoughtworks.selenium.DefaultSelenium;

public class Sample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
DefaultSelenium selenium = new DefaultSelenium("localhost", 4444, "*firefox", "http://google.co.in");
selenium.start();
selenium.open("/");
selenium.windowMaximize();
selenium.type("id=gbqfq", "selenium");
selenium.click("id=gbqfq");
	}
}
