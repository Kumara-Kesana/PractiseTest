package automation;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class Child extends Automation{
	
	private WebDriver driver;
	
	String userDir = System.getProperty("user.dir");

	@Test(priority=0, enabled=true)
	public void Retrive_Data() throws InterruptedException, BiffException, IOException
	{
		Workbook file = Workbook.getWorkbook(new File(userDir+"\\Data\\Facebook.xls"));
		Sheet data = file.getSheet("Sheet1");
		Thread.sleep(2000);
		driver.findElement(By.id("email")).sendKeys(data.getCell(0, 0).getContents());
		driver.findElement(By.id("pass")).sendKeys(data.getCell(1, 0).getContents());
		Thread.sleep(3000);
	}

}
