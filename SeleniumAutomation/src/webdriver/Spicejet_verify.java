package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class Spicejet_verify {
	public WebDriver driver;
  @Test
  public void onewaySearch() throws Exception {
	  driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.linkText("Hyderabad (HYD)")).click();
		driver.findElement(By.linkText("Bengaluru (BLR)")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("ctl00_mainContent_txt_Fromdate")).click();
		Thread.sleep(1000);
		driver.findElement(By.linkText("30")).click();
	new Select(driver.findElement(By.id("ctl00_mainContent_ddl_Adult"))).selectByVisibleText("2 Adults");
	new Select(driver.findElement(By.id("ctl00_mainContent_ddl_Child"))).selectByVisibleText("1 Child");
	driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();
	}
  @Test
	public void verifyjavascripyalerts() throws Exception{
		String str;
		str = driver.switchTo().alert().getText();
		System.out.print(str);
		Thread.sleep(1000);
		driver.switchTo().alert().accept();	
  }
  @Test
  public void verifypopup() throws Exception{
		String str = driver.getWindowHandle();
		driver.findElement(By.linkText("Currency Converter")).click();
		driver.switchTo().window("converter");
	new Select(driver.findElement(By.id("CurrencyConverterCurrencyConverterView_DropDownListBaseCurrency"))).selectByVisibleText("US Dollars(USD)");
	new Select(driver.findElement(By.id("CurrencyConverterCurrencyConverterView_DropDownListConversionCurrency"))).selectByVisibleText("Indian Rupee(INR)");
	driver.findElement(By.id("CurrencyConverterCurrencyConverterView_TextBoxAmount")).sendKeys("1000");
	driver.findElement(By.id("CurrencyConverterCurrencyConverterView_ButtonConvert")).click();
	Thread.sleep(5000);
	driver.findElement(By.id("ButtonCloseWindow")).click();
	driver.switchTo().window(str);
	new Select(driver.findElement(By.id("AvailabilitySearchInputSelectViewdestinationStation1"))).selectByVisibleText("Ahmedabad (AMD)");
	}
  @BeforeTest
  public void beforeTest() {
	  driver = new FirefoxDriver();
	  driver.get("http://www.spicejet.com");
  }

  @AfterTest
  public void afterTest() {
  }

}
