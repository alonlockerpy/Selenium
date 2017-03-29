
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Selenium_Lesson11_class 
{
	public static WebDriver driver;
	
	@BeforeClass
	public static void BC()
	{
		System.setProperty("webdriver.chrome.driver", "/home/alonlocker/Drivers/chromedriver");
		driver = new ChromeDriver();
	}
	
	@Test
	public void LocatorsTest()
	{
		driver.get("http://1776740_alonl:al0545757044@blog.yoniflenner.net/members/ex07_controllers.html");
		System.out.println("Open yoni locator page 2");
		
		driver.findElement(By.name("firstname")).sendKeys("Alon");
		driver.findElement(By.name("lastname")).sendKeys("Locker");
		driver.findElement(By.id("exp-6")).click();
		
		Select continentsDropDown = new Select(driver.findElement(By.id("continents")));
		continentsDropDown.selectByVisibleText("North America");
		
		driver.findElement(By.id("submit")).click();
		
		String url = driver.getCurrentUrl();
		if(url.contains("firstname=Alon") && url.contains("lastname=Locker"))
		{
			System.out.println("TEST PASSED :)");
		}
		else
		{
			System.out.println("TEST FAILED :(");
		}
	}
}
