package automation;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class Automation {
	
	public static WebDriver driver;
	
	String browse = "firefox";
	String userDir = System.getProperty("user.dir");
	String url = "https://www.facebook.com/";
	String urlr = "https://www.romanoriginals.co.uk/";
	
	@BeforeTest()
	public void setup()
	{
		if(browse.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", userDir+"\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browse.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", userDir+"\\drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
	driver.manage().window().maximize();
	//driver.get(url);
	
	}
	
	
	@Test(priority=1, enabled=false)
	public void Drop_Down() throws InterruptedException
	{
		driver.findElement(By.id("u_0_2")).click();
		Thread.sleep(3000);
		new Select(driver.findElement(By.id("day"))).selectByVisibleText("19");
		new Select(driver.findElement(By.id("month"))).selectByVisibleText("Apr");
		new Select(driver.findElement(By.id("year"))).selectByVisibleText("2012");
		Thread.sleep(3000);
		
	}
	@Test(priority=2, enabled = false)
	public void Drop_Down_Data() throws InterruptedException
	{
		WebElement day = driver.findElement(By.id("day"));
		List<WebElement> days = day.findElements(By.tagName("option"));
		for(int i=0; i<days.size();i++)
		{
			System.out.println(days.get(i).getText());
		}
		System.out.println("Printed list of days");
		Thread.sleep(3000);
		
		WebElement month = driver.findElement(By.id("month"));
		List<WebElement> months = month.findElements(By.tagName("option"));
		for(int j=0;j<months.size(); j++)
		{
			System.out.println(months.get(j).getText());
			}
		System.out.println("Printed list of months");
		Thread.sleep(3000);
		
		WebElement year = driver.findElement(By.id("year"));
		List<WebElement> years = driver.findElements(By.tagName("option"));
		for(int k=0; k<years.size();k++)
		{
			System.out.println(years.get(k).getText());
		}
		System.out.println("Printed list of Years");
		
	}
	
	@Test(priority=0, enabled =true)
	public void Verifying_Values() throws InterruptedException
	{
		WebElement newin = driver.findElement(By.xpath("//*[@id=\"menu2\"]/ul/li[1]/a"));
		Actions hover = new Actions(driver);
		hover.moveToElement(newin).perform();
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div[1]/div[1]/div/div[3]/div[2]/div/div/div[1]/div[1]/div/div[1]/a/picture/img")).click();
	    WebElement productcode = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[1]/div[1]/div[3]/div/div/div[1]/div/ul/li[1]"));
	    String code = productcode.getText();
	    Assert.assertEquals(code, "Style: 1907-4734");
	    System.out.println(code);
	    Thread.sleep(3000);
	    
		}
	
	@AfterTest()
	public void teardown()
	{
		driver.close();
	}

}
