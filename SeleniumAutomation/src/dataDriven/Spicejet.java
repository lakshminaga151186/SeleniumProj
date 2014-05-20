package dataDriven;

import java.io.FileInputStream;
import jxl.Sheet;
import jxl.Workbook;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverBackedSelenium;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import com.thoughtworks.selenium.Selenium;

public class Spicejet {
	public WebDriver driver;
	public Selenium selenium;
	String str; 
  @Test
  public void reusablescript() throws Exception {
	  FileInputStream fi = new FileInputStream("E:\\Testing projects\\testdata\\Spicejetinputdat.xls");
	  Workbook w = Workbook.getWorkbook(fi);
	  Sheet s =w.getSheet(0);
	  for (int i = 1; i < s.getRows(); i++) {
		  if (s.getCell(2, i).getContents().equalsIgnoreCase("textbox")) {
			  if (selenium.isElementPresent(s.getCell(2,i).getContents())) {
				  selenium.type(s.getCell(0,i).getContents(), s.getCell(3, i).getContents());
				  str = "pass";
			}	else{
				str = "fail";
				System.out.println("invalid");
		}
		  }
		  else if (s.getCell(2, i).getContents().equalsIgnoreCase("dropdown"))
		  {
			  if (selenium.isElementPresent(s.getCell(0,i).getContents())) {
				  selenium.select(s.getCell(0,i).getContents(),s.getCell(3,i).getContents());
				str="pass";
			}else{
			str= "fail";
			System.out.println("invalid");
			}	
		}
		  else if (s.getCell(2, i).getContents().equalsIgnoreCase("radiobutton")
				  ||s.getCell(2, i).getContents().equalsIgnoreCase("button")
				  ||s.getCell(2, i).getContents().equalsIgnoreCase("checkbox")
				  ||s.getCell(2, i).getContents().equalsIgnoreCase("link")) 
		  {
				  if (selenium.isElementPresent(s.getCell(0,i).getContents())){
				selenium.click(s.getCell(0,i).getContents());
				  str ="pass";
			  }else {
				str = "fail";
				System.out.println("invalid");				
			}
			  }
		  else if (s.getCell(2,i).getContents().equalsIgnoreCase("Url")) {
			  driver.get(s.getCell(0,i).getContents());
			
		}

	  else if (s.getCell(2,i).getContents().equalsIgnoreCase("wait")) {
		Thread.sleep(2000);
		
	}
	else if(s.getCell(2, i).getContents().equalsIgnoreCase("alert"))
	{
		if(s.getCell(3, i).getContents().equalsIgnoreCase("ok"))
		{
			driver.switchTo().alert().accept();
		}else{
			driver.switchTo().alert().dismiss();
		}
	}
	  }
  }
  @BeforeTest
  public void beforeTest() {
	  driver = new FirefoxDriver();
	  selenium = new WebDriverBackedSelenium(driver, "http://www.spicejet.com");
  }

}
