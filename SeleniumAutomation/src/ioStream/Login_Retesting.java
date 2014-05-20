package ioStream;

import java.io.FileInputStream;

import jxl.Sheet;
import jxl.Workbook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.thoughtworks.selenium.Selenium;

public class Login_Retesting {
	public WebDriver driver;
	public Selenium selenium;
  @Test
public void f() throws Exception{
FileInputStream fi=new FileInputStream(
				"E:\\workspace 1\\Testdata\\Login1.xls");
Workbook w=Workbook.getWorkbook(fi);
Sheet s=w.getSheet("Sheet1");
for (int i = 1; i < s.getRows(); i++) {
	driver.findElement(By.id("f_id")).sendKeys(s.getCell(0, i).getContents());
	driver.findElement(By.id("f_pwd")).sendKeys(s.getCell(1, i).getContents());
	driver.findElement(By.cssSelector("input.signin")).click();
	Thread.sleep(2000);
	if(selenium.isElementPresent("link=Sign out"))
	{
	driver.findElement(By.linkText("Sign out")).click();
	Thread.sleep(1000);
	 driver.get("http://mail.in.com");
	}else{
		System.out.println("Invalid credential");
	}
}

  }
  @BeforeTest
  public void beforeTest() {
	  driver=new FirefoxDriver();
	  selenium=new org.openqa.selenium.WebDriverBackedSelenium(driver, "http://mail.in.com");
	  driver.get("http://mail.in.com");
  }
}










