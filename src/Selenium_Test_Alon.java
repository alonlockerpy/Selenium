import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Selenium_Test_Alon
{
	public static WebDriver driver;
	
	@BeforeClass
	public static void BC()
	{
		String browserDriver = "chromedriver.exe";
		String winWebDriverPath = "C:\\selenium\\chromedriver_win32\\" + browserDriver;
		System.setProperty("webdriver.chrome.driver", winWebDriverPath);
		driver = new ChromeDriver();
		System.out.println("Open CH browser.");
		
		driver.get("http://1776740_alonl:al0545757044@blog.yoniflenner.net/members/pizza/");
		System.out.println("Navigate to pizza page.");
	}
	
	
	@Test
	public void alo()
	{
		String price = driver.findElement(By.xpath("//span[text()='$7.50']")).getText();
		assertEquals("Price not as expected", "$7.50", price);
		System.out.println("Start price: " + price);
	}
	
	@Test
	public void blo()
	{
		driver.findElement(By.name("input_22.3")).sendKeys("Alon");
		driver.findElement(By.name("input_22.6")).sendKeys("Locker");
		System.out.println("Enter name: Alon Locker");
		
		Select pizzaDropDown = new Select(driver.findElement(By.id("input_5_21")));
		pizzaDropDown.selectByVisibleText("Delivery +$3.00");
		System.out.println("Select: Delivery");
		
		String price = driver.findElement(By.xpath("//span[text()='$10.50']")).getText();
		assertEquals("Price not as expected", "$10.50", price);
		System.out.println("New price: " + price);
	}
	
	@Test
	public void clo()
	{
		WebElement iframe1 = driver.findElement(By.cssSelector("iframe[src='coupon.html']"));
		driver.switchTo().frame(iframe1);
		
		String coupon = driver.findElement(By.id("coupon_Number")).getText();
		driver.switchTo().defaultContent();
		
		driver.findElement(By.name("input_20")).sendKeys(coupon);
		System.out.println("Get coupon: " + coupon);
		
		driver.findElement(By.id("gform_submit_button_5")).click();
		Alert Popup = driver.switchTo().alert();
		
		String alertWindowText = Popup.getText();
		assertEquals("Alert window text is not as expected","Alon Locker " + coupon ,alertWindowText);
		System.out.println("Alert window text: Alon Locker " + coupon);
		
		Popup.accept();
	}
	
	@AfterClass
	public static void AC()
	{
		driver.quit();
		System.out.println("Close CH browser");
	}
	
}
