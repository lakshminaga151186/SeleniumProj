package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class AllBrowsers {
	public WebDriver driver;

	public void launchFirefox() {
		driver = new FirefoxDriver();
		driver.get("http://www.google.co.in");
	}

	public void launchIE() {
		System.setProperty("webdriver.ie.driver",
				"E:\\softwares\\SeleniumDump\\Lib\\IEDriverServer.exe");
		driver = new InternetExplorerDriver();
		driver.get("http://www.google.co.in");

	}

	public void launchChrome() {
		System.setProperty("webdriver.chrome.driver",
				"E:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://www.google.co.in");
		driver.findElement(By.id("gbqfq")).sendKeys("gmail mail");
	}
	
	public void launchGmailChrome() throws Exception {
		System.setProperty("webdriver.chrome.driver",
				"E:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://www.gmail.com");
		driver.findElement(By.id("Email")).sendKeys("sateeshkrnl");
		driver.findElement(By.id("Passwd")).sendKeys("hurry_430");
		driver.findElement(By.id("signIn")).click();
		Thread.sleep(60000);
		//driver.findElement(By.xpath("//html/body/div[5]/div[2]/div/div[2]/div/div/div/div[2]/div/div/div/div/div")).click();
		/*driver.findElement(By.xpath("//div[text()='COMPOSE']")).click();
		Thread.sleep(60000);
		driver.findElement(By.name("to")).sendKeys("lakshminaga151186@gmail.com");
		driver.findElement(By.name("subjectbox")).sendKeys("hi");
		//driver.findElement(By.id(":nk")).sendKeys("please find attachment");
		driver.findElement(By.xpath("//div[text()='Send']")).click();*/
		driver.findElement(By.xpath("html/body/div[7]/div[2]/div/div[1]/div[3]/div[1]/div[1]/div[1]/div[2]/div[5]/div[1]/a")).click();
		Thread.sleep(30000);
		driver.findElement(By.linkText("Sign out")).click();
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		AllBrowsers m = new AllBrowsers();
		// m.launchFirefox();
		//m.launchIE();
		m.launchGmailChrome();
	}

}
