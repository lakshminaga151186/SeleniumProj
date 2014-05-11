package TestNG;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class CaptureScreenshot {
	public WebDriver driver;
	public void takescreenshot(String str) throws Exception{
		DateFormat df = new SimpleDateFormat("yyyy_MMM_dd HH_mm_ss");
		 Date d = new Date();
		 String time=df.format(d);
		 File f = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	     FileUtils.copyFile(f, new File("E:\\workspace 1\\"+str+time+".png"));		
		}
	  public void clickelements(String str){
		  driver.findElement(By.linkText(str)).click();
		  driver.findElement(By.linkText("Home")).click();
	  }
	  @Test
	  public void f() throws Exception{
		  takescreenshot("Homepage");
		  driver.findElement(By.linkText("Hotels")).click();
		  takescreenshot("Hotel");
		  Thread.sleep(5000);
		  clickelements("Add-ons");
		  takescreenshot("Add-ons");
		  clickelements("myspicetrip");
		   takescreenshot("myspicetrip");
  }
  @BeforeTest
  public void beforeTest() {
	  driver=new FirefoxDriver();
	  driver.get("http://spicejet.com");
  }
  @AfterTest
  public void afterTest() {
  }

}
