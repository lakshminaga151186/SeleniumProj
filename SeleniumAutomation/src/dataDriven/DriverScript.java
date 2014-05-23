package dataDriven;

import java.io.FileInputStream;

import jxl.Sheet;
import jxl.Workbook;

import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverBackedSelenium;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

import com.beust.jcommander.Parameter;
import com.thoughtworks.selenium.Selenium;

public class DriverScript {
	public WebDriver driver;
	public Selenium selenium;
	public String str;
  @Test
  public void reUsableScript() throws Exception{
FileInputStream fi=new FileInputStream("E:\\workspace 1\\SeleniumAutomation_15May_6PM\\Testdata\\Register.xls");	  
Workbook w=Workbook.getWorkbook(fi);
Sheet s=w.getSheet(0);
for (int i = 1; i < s.getRows(); i++) {
	if(s.getCell(2, i).getContents().equalsIgnoreCase("textbox"))
	{
		if(selenium.isElementPresent(s.getCell(0, i).getContents()))
		{
		selenium.type(s.getCell(0, i).getContents(), s.getCell(3, i).getContents());
//driver.findElement(By.id(s.getCell(0, i).getContents())).sendKeys(s.getCell(3, i).getContents());
		str="Pass";
		}else{
			str="Fail";
			System.out.println("Not available");
		}
	}
	else if(s.getCell(2, i).getContents().equalsIgnoreCase("dropdown"))
	{
		if(selenium.isElementPresent(s.getCell(0, i).getContents()))
		{
		selenium.select(s.getCell(0, i).getContents(), s.getCell(3, i).getContents());
//new Select(driver.findElement(By.id(s.getCell(0, i).getContents()))).selectByVisibleText(s.getCell(3, i).getContents());
		str="Pass";
		}else{
			str="Fail";
			System.out.println("Not available");
		}
	}
	else if(s.getCell(2, i).getContents().equalsIgnoreCase("radiobutton")
			||s.getCell(2, i).getContents().equalsIgnoreCase("button")
			||s.getCell(2, i).getContents().equalsIgnoreCase("checkbox")
			||s.getCell(2, i).getContents().equalsIgnoreCase("link"))
	{
		if(selenium.isElementPresent(s.getCell(0, i).getContents()))
		{	
		//driver.findElement(By.xpath(s.getCell(0, i).getContents())).click();
		selenium.click(s.getCell(0, i).getContents());
		str="Pass";
		}else{
			str="Fail";
			System.out.println("Not available");
		}
	}
	else if(s.getCell(2, i).getContents().equalsIgnoreCase("url"))
	{
		driver.get(s.getCell(0, i).getContents());
		str="Pass";
	}
	else if(s.getCell(2, i).getContents().equalsIgnoreCase("wait"))
	{
		Thread.sleep(4000);
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
/*	else if(s.getCell(2, i).getContents().equalsIgnoreCase("button"))
	{
		Thread.sleep(1000);
		driver.findElement(By.id(s.getCell(0, i).getContents())).click();
	}*/
	
}
  }
  @org.testng.annotations.Parameters("browser")
  @BeforeTest
  public void beforeTest(String str) {
	  if (str.equalsIgnoreCase("chrome")) 
	  {
		System.setProperty("webdriver.chome.driver", "E:\\softwares\\SeleniumDump\\Lib\\chromedriver.exe");
		driver = new ChromeDriver();
		selenium = new WebDriverBackedSelenium(driver, "http://www.mail.in.com");
	  }
	  if (str.equalsIgnoreCase("ie")) 
	  {
		System.setProperty("webdriver.ie.driver", "E:\\softwares\\SeleniumDump\\Lib\\IEDriverServer.exe");
		driver = new InternetExplorerDriver();
		selenium = new WebDriverBackedSelenium(driver, "http://www.mail.in.com");
	  }
	  if (str.equalsIgnoreCase("firefox")) 
	  {
		  driver=new FirefoxDriver();
		selenium=new org.openqa.selenium.WebDriverBackedSelenium(driver, "http://www.mail.in.com");
	  }
		
		//driver.get("http://mail.in.com");
		//driver.findElement(By.cssSelector("input.registernow")).click();
  }

  @AfterTest
  public void afterTest() {
  }

}
