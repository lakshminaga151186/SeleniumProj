package seleniumrc;

import com.thoughtworks.selenium.DefaultSelenium;

public class Mail_Register {
	
	public DefaultSelenium sel = new DefaultSelenium("localhost", 4444, "*firefox", "http://www.mail.in.com");
		
	public void openURL(){
		sel.start();
		sel.setTimeout("300000");
		sel.open("/");
		sel.windowMaximize();
	}
	public void register() throws Exception {
		sel.click("css=input.registernow");
		sel.waitForPageToLoad("300000");
		sel.type("fname", "lakshmi");
		sel.select("day","10");
		sel.select("month", "Mar");
		sel.select("year", "1999");
		Thread.sleep(2000);
		sel.click("xpath=(//input[@name='radiousername'])[2]");
		Thread.sleep(2000);
		sel.type("password", "chinnu999");
		sel.type("repassword", "chinnu999");
		sel.type("altemail", "nagalakshmi816@gmail.com");
		sel.click("imageField");
		//selenium.waitForPageToLoad("10000");
		Thread.sleep(2000);
		sel.click("xpath=(//input[@id='gender'])[2]");
		sel.select("mcountry", "India");
		sel.select("mcity", "Hyderabad");
		sel.select("occupation", "Professional");
		sel.select("industry", "Information Technology");
		sel.select("income", "5 Lakh to 10 Lakh");
		sel.click("terms");
		Thread.sleep(2000);
		sel.click("//input[@name='']");
	}
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Mail_Register d=new Mail_Register();
		d.openURL();
		d.register();
	}
}
