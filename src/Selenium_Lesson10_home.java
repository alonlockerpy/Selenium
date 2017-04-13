import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium_Lesson10_home 
{
	public static WebDriver driver;
	
	@BeforeClass
	public static void BC()
	{
		//chromedriver, geckodriver, IEDriverServer
		String browserDriver = "chromedriver.exe";
		String winWebDriverPath = "C:\\selenium\\chromedriver_win32\\" + browserDriver;
		System.setProperty("webdriver.chrome.driver", winWebDriverPath);
		driver = new ChromeDriver();
	}
	
	@Test
	public void LocatorsTest()
	{
		driver.get("http://1776740_alonl:al0545757044@blog.yoniflenner.net/members/ex04_locators.html");
		System.out.println("Open yoni locator page");
		
		WebElement L1 = driver.findElement(By.id("locator_id"));
		System.out.println("Locator 1: " + L1);
		
		WebElement L2 = driver.findElement(By.name("locator_name"));
		System.out.println("Locator 2: " + L2);
		
		WebElement L3 = driver.findElement(By.tagName("p"));
		System.out.println("Locator 3: " + L3);
		
		WebElement L4 = driver.findElement(By.className("locator_class"));
		System.out.println("Locator 4: " + L4);
		
		WebElement L5 = driver.findElement(By.linkText("myLocator(5)"));
		System.out.println("Locator 5: " + L5);
		
		WebElement L6 = driver.findElement(By.partialLinkText("(6)"));
		System.out.println("Locator 6: " + L6);
		
		WebElement L7 = driver.findElement(By.xpath("//input[@myname='selenium']"));
		System.out.println("Locator 7: " + L7);
		
		WebElement L8 = driver.findElement(By.cssSelector("button[class='btn btn-2']"));
		System.out.println("Locator 8: " + L8);
	}
 
}
