package seleniumrc;

import com.thoughtworks.selenium.DefaultSelenium;

public class Google_Change {
	DefaultSelenium sel = new DefaultSelenium("localhost", 4444, "*firefox", "http://www.google.co.in");
	public void openURL(){	
		sel.start();
		sel.open("/");
		sel.waitForPageToLoad("3000");
		sel.windowMaximize();
	}
		public void lang() throws Exception{
				sel.click("link=Hindi");
			//sel.waitForPageToLoad("30000");
				Thread.sleep(5000);
				sel.click("//font[@id='addlang']/a[2]");
				sel.waitForPageToLoad("30000");
				sel.click("//font[@id='addlang']/a[3]");
				sel.waitForPageToLoad("30000");
				sel.click("//font[@id='addlang']/a[4]");
				sel.waitForPageToLoad("30000");
				sel.click("//font[@id='addlang']/a[5]");
				sel.waitForPageToLoad("30000");
				sel.click("//font[@id='addlang']/a[6]");
				sel.waitForPageToLoad("30000");
				sel.click("//font[@id='addlang']/a[7]");
				sel.waitForPageToLoad("30000");
				sel.click("//font[@id='addlang']/a[8]");
				sel.waitForPageToLoad("30000");
				sel.click("//font[@id='addlang']/a[9]");
				sel.waitForPageToLoad("30000");
		}
				public static void main(String[] args) throws Exception{
			// TODO Auto-generated method stub
					Google_Change b = new Google_Change();
						b.openURL();
						b.lang();

	}

}
