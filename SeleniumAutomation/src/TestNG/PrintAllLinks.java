package TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class PrintAllLinks {
	public WebDriver driver;
 
	@Test
	public void verifylinks() {
	java.util.List<WebElement> str =driver.findElements(By.tagName("a"));
				System.out.println(str.size());
	
for (int i = 0; i < str.size(); i++) {
		 
		 System.out.println(str.get(i).getText());
	}
  }
  @BeforeTest
  public void beforeTest() {
	  driver = new FirefoxDriver();
	  driver.get("http://www.spicejet.com");
  }

  @AfterTest
  public void afterTest() {
  }

}
