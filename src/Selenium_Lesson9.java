
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class Selenium_Lesson9  
{
	public static WebDriver driver;
	public String SiteTitleExpected = "IMDb - Movies, TV and Celebrities - IMDb";
	
	//@BeforeClass
	//public static void BC()
	//{
		//System.setProperty("webdriver.chrome.driver", "/home/alonlocker/Drivers/chromedriver");
		//driver = new ChromeDriver();
	//}
	
	@Test
	public void T1()
	{
		//driver.get("http://www.seleniumhq.org/");
		//System.out.println("Open CH with seleniumhq site");
		String word = "Selenium";
		pageObjectTest Test = new pageObjectTest();
		Test.OpenPage("https://www.google.com");
		
		Test.Search(word);
		Test.results(word);
		
		//WebElement ID = driver.findElement(By.id("menu_about"));
		//System.out.println("find about button by id" + ID);
		
		//WebElement LINKT = driver.findElement(By.linkText("About"));
		//System.out.println("find about button by link" + LINKT);
		
		//List<WebElement> TotalLinks = driver.findElements(By.tagName("a"));
		//int total = TotalLinks.size();
		//System.out.println("Total links in the page: " + total);
		
		//List<WebElement> TotalS = driver.findElements(By.partialLinkText("Selenium"));
		//int totalS = TotalS.size();
		//System.out.println("Total links in the page with name Selenium: " + totalS);
		
		//List<WebElement> Totals = driver.findElements(By.partialLinkText("selenium"));
		//int totals = Totals.size();
		//System.out.println("Total links in the page with name selenium: " + totals);
	}
	//@AfterClass
	//public static void AC()
	//{
	//	driver.quit();
	//	System.out.println("Close CH browser");
	//}
}
