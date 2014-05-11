package TestNG;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class Textbox_dropdowns_mailIn {
	public WebDriver driver;
  @Test(enabled=false)
  public void textboxes_ids() {
	  driver.findElement(By.cssSelector("input.registernow")).click();
	  String str =driver.findElement(By.xpath("//html/body/div[2]/div[2]/table/tbody/tr/td")).getText();
	  System.out.println(str);
	  List<WebElement> str1=driver.findElements(By.tagName("input"));
	  System.out.println(str1.size());
	  for (int i = 0; i < str1.size(); i++) {
		  if(str1.get(i).getAttribute("class").equalsIgnoreCase("textbox_1")){
		  System.out.println(str1.get(i).getAttribute("id"));
		  }
		  if(str1.get(i).getAttribute("type").equalsIgnoreCase("image")){
			  System.out.println(str1.get(i).getAttribute("id"));
		    }
		  }
	  }
  @Test
  public void radio_id() throws Exception{
	  driver.findElement(By.cssSelector("input.registernow")).click();
	  driver.findElement(By.id("fname")).sendKeys("devi");
	 new org.openqa.selenium.support.ui.Select(driver.findElement(By.id("day"))).selectByVisibleText("6");
	 new org.openqa.selenium.support.ui.Select(driver.findElement(By.id("month"))).selectByVisibleText("Jun");
	 new org.openqa.selenium.support.ui.Select(driver.findElement(By.id("year"))).selectByVisibleText("1995");
	 Thread.sleep(1000);
	 List<WebElement> s = driver.findElements(By.tagName("input"));
	 System.out.println(s.size());
	 for (int i = 0; i < s.size(); i++) {
		 if(s.get(i).getAttribute("type").equalsIgnoreCase("radio")){
			 System.out.println(s.get(i).getAttribute("onclick")); 
		 }
	}
	 driver.findElement(By.xpath("//html/body/div[2]/div[2]/table/tbody/tr/td/div[2]/form/div/table/tbody[2]/tr/td[2]/div/div/table/tbody/tr[2]/td/table/tbody/tr/td[3]/input")).click();
	 Thread.sleep(1000);
	 driver.findElement(By.id("password")).sendKeys("devi999");
	 driver.findElement(By.id("repassword")).sendKeys("devi999");
	 driver.findElement(By.id("altemail")).sendKeys("devi123@gmail.com");
	 Thread.sleep(5000);
	 driver.findElement(By.xpath("//*[@id='imageField']")).click();
	 Thread.sleep(5000);
	 String st =driver.findElement(By.xpath("//html/body/div[2]/div[2]/table/tbody/tr/td")).getText();
	        System.out.println(st);
	List<WebElement>  str2 =driver.findElements(By.tagName("input"));
	System.out.println(str2.size());
	for (int i = 0; i < str2.size(); i++) {
		if(str2.get(i).getAttribute("id").equalsIgnoreCase("gender")) {
			System.out.println(str2.get(i).getAttribute("name"));	
		}
		if (str2.get(i).getAttribute("type").equalsIgnoreCase("image")) {
			System.out.println(str2.get(i).getAttribute("onclick"));
			
		}
	}
	 List<WebElement> str3 = driver.findElements(By.className("textbox_2"));
	 System.out.println(str3.size());
	 for (int i = 0; i < str3.size(); i++) {
		 System.out.println(str3.get(i).getAttribute("id"));
	}
	 
	 driver.findElement(By.xpath("//html/body/div[2]/div[2]/table/tbody/tr/td/div[2]/form/div/div/table/tbody/tr/td[2]/input[2]")).click();
	 new org.openqa.selenium.support.ui.Select(driver.findElement(By.id("mcountry"))).selectByVisibleText("India");
	 new org.openqa.selenium.support.ui.Select(driver.findElement(By.id("mcity"))).selectByVisibleText("Hyderabad");
	new org.openqa.selenium.support.ui.Select(driver.findElement(By.id("occupation"))).selectByVisibleText("Professional"); 
    driver.findElement(By.id("terms")).click();
    driver.findElement(By.xpath("/html/body/div[2]/div[2]/table/tbody/tr/td/div[2]/form/div/div/table/tbody[3]/tr[7]/td[2]/input")).click();
  }  
  @BeforeTest
  public void beforeTest() {
	  driver = new FirefoxDriver();
	  driver.get("http://www.mail.in.com");
  }

  @AfterTest
  public void afterTest() {
  }

}
