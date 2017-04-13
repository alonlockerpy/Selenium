import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium_Class_SwitchWindows 
{
	public static WebDriver driver;
	
	@BeforeClass
	public static void BC()
	{
		System.setProperty("webdriver.chrome.driver", "/home/alonlocker/Drivers/chromedriver");
		driver = new ChromeDriver();
	}
	
	@Test
	public void SwitchWindow() throws InterruptedException
	{
		driver.get("http://1776740_alonl:al0545757044@blog.yoniflenner.net/members/ex09_switch_navigation.html");
		System.out.println("Open switch window page");
	
		/*driver.findElement(By.id("btnAlert")).click();
		Alert Popup1 = driver.switchTo().alert();
		System.out.println(Popup1.getText());
		Popup1.accept();
		try
		{
			String result1 = driver.findElement(By.id("output")).getText();
			assertEquals("Alert not seen","Alert is gone.",result1);	
		}
		catch (Exception e) {
			System.out.println("Fail on result Alert validation");
		}
	
		driver.findElement(By.id("btnPrompt")).click();
		Alert Popup2 = driver.switchTo().alert();
		Popup2.sendKeys("Alon Locker");
		Popup2.accept();
		try
		{
			String result2 = driver.findElement(By.id("output")).getText();
			assertEquals("Name not seen","Alon Locker",result2);	
		}
		catch (Exception e) {
			System.out.println("Fail on result name validation");
		}
	
		driver.findElement(By.id("btnConfirm")).click();
		Alert Popup3 = driver.switchTo().alert();
		Popup3.dismiss();
		
		try
		{
			String result3 = driver.findElement(By.id("output")).getText();
			assertEquals("Rejected not seen","Rejected!",result3);	
		}
		catch (Exception e) {
			System.out.println("Fail on result Rejected! validation");
		}*/
	
		WebElement iframe1 = driver.findElement(By.cssSelector("iframe[src='ex09_newFrame.html']"));
		System.out.println("check1");
		driver.switchTo().frame(iframe1);
		System.out.println("check2");
		iframe1.findElement(By.id("iframe_container"));
		System.out.println("check3");
	}
	
	@AfterClass
	public static void close()
	{
		//driver.quit();
	}
}
