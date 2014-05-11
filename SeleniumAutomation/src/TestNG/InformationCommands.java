package TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class InformationCommands {
	public WebDriver driver;
  @Test
  public void googleprint() {
	 String str = driver.findElement(By.linkText("Hindi")).getText();
	 System.out.println(str);
	 String str1 =driver.findElement(By.id("gbqfba")).getAttribute("aria-label");
	 System.out.println(str1);
	 String str2 =driver.findElement(By.id("hplogo")).getAttribute("title");
	 System.out.println(str2);
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
