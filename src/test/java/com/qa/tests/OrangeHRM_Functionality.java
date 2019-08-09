package com.qa.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
// Hello
public class OrangeHRM_Functionality {
    WebDriver driver;
	@BeforeMethod
	public void browserlaunch()
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Jenkins maven git\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.testingmasters.com/hrm");
		
	}
	
	@Test(priority=1)
	
	public void pagetitleverify() throws InterruptedException
	{
		String s=driver.getTitle();
		System.out.println("The page title is:" + s);
		Assert.assertEquals(s, "OrangeHRM");
		Thread.sleep(2000);
	}
	
	@Test(priority=2)
	
	public void verifylogin() throws InterruptedException
	{
		driver.findElement(By.xpath("//*[@id='txtUsername']")).sendKeys("user02");
		driver.findElement(By.xpath("//*[@id='txtPassword']")).sendKeys("TM1234");
		driver.findElement(By.xpath("//*[@id='btnLogin']")).click();
		Thread.sleep(2000);
	}
	@AfterMethod
	
	public void quitbrowser()
	{
		driver.quit();
	}
	
}
