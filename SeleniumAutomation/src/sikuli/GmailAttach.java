package sikuli;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.sikuli.script.Screen;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

public class GmailAttach {
	public WebDriver driver;
	public org.sikuli.script.Screen s= new Screen();
  @Test
  public void attachment() throws Exception {
	  driver.findElement(By.id("Email")).sendKeys("lakshminaga151186");
	  driver.findElement(By.id("Passwd")).sendKeys("chinnumechanical");
	  driver.findElement(By.id("signIn")).click();
	  Thread.sleep(6000);
	  driver.findElement(By.xpath("//div[@id=':hj']/div/div")).click();
	  Thread.sleep(6000);
	  driver.findElement(By.xpath("//*[@name='to']")).sendKeys("nagalakshmi816@gmail.com");
	  driver.findElement(By.xpath("//*[@name='subjectbox']")).sendKeys("HI");
      driver.findElement(By.xpath("//div[@aria-label='Attach files']")).click();
      s.click("E:\\workspace 1\\webdriver\\src.sikuli\\1399974860452.png");
      s.click("E:\\workspace 1\\webdriver\\src.sikuli\\1399974878890.png");
      s.type("E:\\workspace 1\\webdriver\\src.sikuli\\1399974878890.png","flowchart.doc");
      s.click("E:\\workspace 1\\webdriver\\src.sikuli\\1399974738799.png");
  }
  @BeforeTest
  public void beforeTest() {
	  driver = new FirefoxDriver();
	  driver.get("http://www.gmail.com");
  }

}
