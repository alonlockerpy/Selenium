import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium_Lesson_15 
{
public static WebDriver driver;
	
	@BeforeClass
	public static void BC()
	{
		System.setProperty("webdriver.chrome.driver", "/home/alonlocker/Drivers/chromedriver");
		driver = new ChromeDriver();
		
		driver.get("http://1776740_alonl:al0545757044@blog.yoniflenner.net/members/ex08_synchronization.html");
		System.out.println("Open timeout test page");
	}
	
	@Test
	public void ErrorTest() throws InterruptedException
	{
		
			Boolean check =  driver.findElement(By.id("checkbox")).isDisplayed();
			if(check == false)
			{
				System.out.println("Check box not shows!");
			}
			else
			{
				driver.findElement(By.id("btn")).click();
				Thread.sleep(7000);
			}
	}
	
	@Test
	public void ErrorTest2() throws InterruptedException
	{
		try
		{
			driver.findElement(By.id("btn")).click();
			Thread.sleep(7000);
			
			Boolean check =  driver.findElement(By.id("checkbox")).isDisplayed();
			assertTrue("The checkbox is not show!!",check);
		}
		catch (Exception e)
		{
			System.out.println("No element error: " + e);		
		}
		catch (AssertionError ae)
		{
			System.out.println("The assertion failed" + ae);
		}
	}

	@AfterClass
	public static void AC()
	{
		driver.quit();
		System.out.println("Close CH browser");
	}
}
