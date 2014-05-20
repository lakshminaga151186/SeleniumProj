package ioStream;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import jxl.Sheet;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.thoughtworks.selenium.Selenium;
import org.openqa.selenium.WebDriverBackedSelenium;

public class LoginResults_Step3 {
	public WebDriver driver;
	public Selenium selenium;
	public String str;
  @Test
  public void f() throws Exception{
//Reading the testdata file	  
FileInputStream fi=new FileInputStream("E:\\Testing projects\\SeleniumAutomation_16May_6PM\\Testdata\\Login.xls");
Workbook w=Workbook.getWorkbook(fi);
Sheet s=w.getSheet(0);
//Creating a Result file
FileOutputStream fo=new FileOutputStream("E:\\Testing projects\\SeleniumAutomation_16May_6PM\\Results\\LoginResults1.xls");
WritableWorkbook wb=Workbook.createWorkbook(fo);
WritableSheet ws=wb.createSheet("Results", 0);

for (int i = 1; i < s.getRows(); i++) {
//Enter username, password and click on signin by taking test data from input file	
driver.findElement(By.id("f_id")).sendKeys(s.getCell(0, i).getContents());
driver.findElement(By.id("f_pwd")).sendKeys(s.getCell(1, i).getContents());
driver.findElement(By.cssSelector("input.signin")).click();
//Validate signout, if available assign pass to str, else assing fail to str
if(selenium.isElementPresent("link=Sign out"))
{
driver.findElement(By.linkText("Sign out")).click();
Thread.sleep(1000);
driver.get("http://mail.in.com");
str="Pass";
}else{
	str="Fail";
	System.out.println("Invalid credential");
}
//Adding str value to result file
Label result=new Label(2, i, str);
ws.addCell(result);
//Add data to the result file
for (int j = 0; j < s.getColumns(); j++) {
		System.out.println(s.getCell(j, i).getContents());
		Label un=new Label(j, i, s.getCell(j, i).getContents());
		ws.addCell(un);
	}
}
//Add 3 labels to Result file
Label un=new Label(0,0,"Username");
Label pw=new Label(1,0,"Password");
Label rs=new Label(2,0,"Results");
ws.addCell(un);
ws.addCell(pw);
ws.addCell(rs);
//Write and close result file
wb.write();
wb.close();  
  }
  @BeforeTest
  public void beforeTest() {
	  driver=new FirefoxDriver();
	  selenium=new org.openqa.selenium.WebDriverBackedSelenium(driver, "http://mail.in.com");
	  driver.get("http://mail.in.com");
  }
}
