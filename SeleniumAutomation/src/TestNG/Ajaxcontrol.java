package TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class Ajaxcontrol {
	public WebDriver driver;
  @Test
  public void googlesearch() throws Exception {
	  driver.findElement(By.id("gbqfq")).sendKeys("selenium");
	  Thread.sleep(1000);
	  String str=driver.findElement(By.xpath("//html/body/table/tbody/tr/td[2]")).getText();
	  System.out.println(str);
	  String s[] = str.split("\n");
	  System.out.println(s.length);
	  for (int i = 0; i < s.length; i++) {
		  if(s[i].equalsIgnoreCase("selenium tutorial"))
		  {
		  System.out.println(s[i]);
		  driver.findElement(By.id("gbqfq")).clear();
		  driver.findElement(By.id("gbqfq")).sendKeys(s[i]);
		  }
	}
  }
  @BeforeTest
  public void beforeTest() {
	  driver = new FirefoxDriver();
	  driver.get("http://www.google.co.in");
  }

  @AfterTest
  public void afterTest() {
  }

}
