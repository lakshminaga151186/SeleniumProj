package seleniumrc;

import com.thoughtworks.selenium.DefaultSelenium;

public class Google {
DefaultSelenium sel = new DefaultSelenium("localhost", 4444, "*firefox", "http://www.google.co.in");
	public void openURL(){	
		sel.start();
		sel.open("/");
		sel.waitForPageToLoad("3000");
		sel.windowMaximize();
	}
		public void hindi() throws Exception{
		sel.click("link=Hindi");
		//sel.waitForPageToLoad("30000");
		Thread.sleep(5000);
		}
		public void bengali() throws Exception{
			sel.click("link=English");
			sel.waitForPageToLoad("30000");
			sel.click("link=Bengali");
			sel.waitForPageToLoad("30000");
		}
		public void telugu() throws Exception{
			sel.click("link=English");
			sel.waitForPageToLoad("30000");
			sel.click("link=Telugu");
			sel.waitForPageToLoad("30000");
		}
		public void marathi() throws Exception{
			sel.click("link=English");
			sel.waitForPageToLoad("30000");
			sel.click("link=Marathi");
			sel.waitForPageToLoad("30000");
		}
		public void tamil() throws Exception{
			sel.click("link=English");
			sel.waitForPageToLoad("30000");
			sel.click("link=Tamil");
			sel.waitForPageToLoad("30000");
	}
			public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
				Google b = new Google();
				b.openURL();
				b.hindi();
				b.bengali();
				b.telugu();
				b.marathi();
				b.tamil();
	}

}
