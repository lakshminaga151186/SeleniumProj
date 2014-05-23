package dataDriven;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;

import jxl.Sheet;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverBackedSelenium;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

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
	  /*FileOutputStream fo = new FileOutputStream("E:\\Testing projects\\Results\\Spicejetresults.xls");
	  WritableWorkbook wb = Workbook.createWorkbook(fo);
	  WritableSheet ws = wb.createSheet("Results", 0);*/
	  /*System.out.println("--Origin Station Link--"+selenium.isElementPresent("ctl00_mainContent_ddl_originStation1_CTXT"));
	  selenium.click("ctl00_mainContent_ddl_originStation1_CTXT");
	  selenium.click("link=Hyderabad (HYD)");
	  Thread.sleep(1000);
	  List<WebElement> elements=driver.findElements(By.xpath("//a[@text='Tirupati (TIR)']"));
	  for(WebElement element:elements){
		  if(element.isDisplayed())
			  element.click();
	  }*/
	  for (int c = 3; c < s.getColumns(); c++) 
	  {
		  for (int i = 1; i < s.getRows(); i++) 
		  {		  
			if (s.getCell(2, i).getContents().equalsIgnoreCase("textbox")) 
			{
				if (selenium.isElementPresent(s.getCell(0, i).getContents())) {
					selenium.type(s.getCell(0, i).getContents(),s.getCell(c, i).getContents());
					str = "pass";
				} else {
					str = "fail";
					System.out.println("invalid at "+ s.getCell(2, i).getContents());
				}
			}else if (s.getCell(2, i).getContents().equalsIgnoreCase("dropdown") && !(s.getCell(c, i).getContents().equalsIgnoreCase("")))
			{
				if (selenium.isElementPresent(s.getCell(0,i).getContents())) 
				{
					selenium.select(s.getCell(0,i).getContents(),s.getCell(c,i).getContents());
					str="pass";
				}else{
					str= "fail";
					System.out.println("invalid at "+s.getCell(0,i).getContents());
				}	
			}else if (s.getCell(2, i).getContents().equalsIgnoreCase("radiobutton")
					  ||s.getCell(2, i).getContents().equalsIgnoreCase("button")
					  ||s.getCell(2, i).getContents().equalsIgnoreCase("link")) 
			{
			  if(selenium.isElementPresent(s.getCell(0, i).getContents()))
			  {
				 selenium.click(s.getCell(0, i).getContents());
			     str ="pass";
			  }else 
			  {
				str = "fail";
				System.out.println("invalid at "+s.getCell(0, i).getContents());				
			  }
			}else if (s.getCell(2,i).getContents().equalsIgnoreCase("Url")) 
			{
				  driver.get(s.getCell(0,i).getContents());
			}else if (s.getCell(2,i).getContents().equalsIgnoreCase("wait")) 
			{
				Thread.sleep(2000);
			}
			else if(s.getCell(2, i).getContents().equalsIgnoreCase("alert"))
			{
				if(s.getCell(c, i).getContents().equalsIgnoreCase("ok"))
				{
					driver.switchTo().alert().accept();
				}else{
					driver.switchTo().alert().dismiss();
				}
			}
			/*Label results = new Label(9, i, str);
			ws.addCell(results);
			for (int j = 0; j < s.getColumns(); j++) {
				System.out.println(s.getCell(j, i).getContents());
				Label un=new Label(j, i, s.getCell(j, i).getContents());
				ws.addCell(un);
			}
			  Label or = new Label(0, 0, "Objectrepository");
			  Label dn = new Label(1, 0, "Dispalyname");
			  Label ot = new Label(2, 0, "Objecttype");
			  Label td = new Label(c, 0, "testdata");
			  Label rs = new Label(9, 0, "Results");
			  ws.addCell(or);
			  ws.addCell(dn);
			  ws.addCell(ot);
			  ws.addCell(td);
			  ws.addCell(rs);*/
		 }
	 }
	  /*wb.write();
	  wb.close();*/
 }
  
  @BeforeTest
  public void beforeTest() {
	  driver = new FirefoxDriver();
	  //driver.get("http://www.spicejet.com");
	  selenium = new WebDriverBackedSelenium(driver, "http://www.spicejet.com");
  }

}
