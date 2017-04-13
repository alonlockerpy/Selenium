import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class pageObjectTest 
{
	public static WebDriver driver;
	
	public void OpenPage(String url)
	{
		System.setProperty("webdriver.chrome.driver", "/home/alonlocker/Drivers/chromedriver");
		driver = new ChromeDriver();
		driver.get(url);
		System.out.println("Open CH on page: " + url);
	}
	
	public void Search(String serach)
	{
		driver.findElement(By.id("lst-ib")).sendKeys(serach);
		driver.findElement(By.id("lst-ib")).sendKeys(Keys.ENTER);
	}
	
	public void results(String expected)
	{
		if(driver.getTitle().contains(expected))
		{
			System.out.println("Passed");
		}
		else
		{
			
			System.out.println("Fail");
			//System.out.println(key + " " + expected);
		}
	}

}
