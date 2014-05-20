package ioStream;

import java.io.FileInputStream;
import jxl.Sheet;
import jxl.Workbook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverBackedSelenium;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import com.thoughtworks.selenium.Selenium;

public class Login {
	public WebDriver driver;
	public Selenium selenium;
  @Test
  public void gmailLogin() throws Exception {
	  FileInputStream fi = new FileInputStream("E:\\workspace 1\\Testdata\\Login1.xls");
	  Workbook w= Workbook.getWorkbook(fi);
	  Sheet s = w.getSheet("credentials");
	  for (int i= 1; i< s.getRows(); i++) {
		  driver.findElement(By.id("Email")).clear();
		  driver.findElement(By.id("Email")).sendKeys(s.getCell(0,i).getContents());
		  driver.findElement(By.id("Passwd")).clear();
		  driver.findElement(By.id("Passwd")).sendKeys(s.getCell(1,i).getContents());
		  driver.findElement(By.id("signIn")).click();
		  Thread.sleep(60000);
		  if (selenium.isElementPresent("//a[@title='nagalakshmi816@gmail.com']")) {
			  driver.findElement(By.xpath("//a[@title='nagalakshmi816@gmail.com']")).click();
			  driver.findElement(By.linkText("Sign out")).click();
			  driver.findElement(By.id("account-chooser-link")).click();
			  driver.findElement(By.id("edit-account-list")).click();
			  driver.findElement(By.id("choose-account-0")).click();
			  driver.findElement(By.id("edit-account-list")).click();
			  Thread.sleep(2000);
			  driver.get("http://www.gmail.com");
				}  else {
					System.out.println("invalid credenditials");
				}
				
	}
	  
  }
  @BeforeTest
  public void beforeTest() {
	  driver = new FirefoxDriver();
	  selenium = new WebDriverBackedSelenium(driver, "http://www.gmail.com");
	  driver.get("http://www.gmail.com");
  }

}
