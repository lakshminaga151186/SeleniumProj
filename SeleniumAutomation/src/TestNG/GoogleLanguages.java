package TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class GoogleLanguages {
	public WebDriver driver;
		public void clicklanguages(String str) {
	  driver.findElement(By.linkText(str)).click();
	  driver.findElement(By.linkText("English")).click();
  }
  @Test
  public void verifylanguages(){
	  clicklanguages("Hindi");
	  clicklanguages("Bengali");
	  clicklanguages("Telugu");  
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
