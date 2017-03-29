import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Selenium_Lesson_BMI
{
public static WebDriver driver;
	
	@BeforeClass
	public static void BC()
	{
		System.setProperty("webdriver.chrome.driver", "/home/alonlocker/Drivers/chromedriver");
		driver = new ChromeDriver();
	}
	
	@Test
	public void BMICalculateTest()
	{
		driver.get("http://blog.yoniflenner.net/bmi/");
		System.out.println("Open BMI page");
		
		driver.findElement(By.id("weight")).sendKeys("80");
		driver.findElement(By.id("hight")).sendKeys("180");
		
		driver.findElement(By.id("calculate_data")).click();
		
		String BMI = driver.findElement(By.id("bmi_result")).getAttribute("value");
		assertEquals("The found BMI is not as expected!","25",BMI);
	}
	
	@Test
	public void ButtonSizeLocationTest()
	{
		
		int buttonWidth = driver.findElement(By.id("calculate_data")).getSize().getWidth();
		int buttonHight = driver.findElement(By.id("calculate_data")).getSize().getHeight();
		int buttonLocationX = driver.findElement(By.id("calculate_data")).getLocation().getX();
		int buttonLocationY = driver.findElement(By.id("calculate_data")).getLocation().getY();
		
		System.out.println("Button size: " + buttonWidth + "X" + buttonHight);
		System.out.println("Button location: " + buttonLocationX + "X" + buttonLocationY);
		assertEquals("The button width size is not much!",133,buttonWidth);
		assertEquals("The button hight size is not much!",35,buttonHight);
	}
	
	@Test
	public void ButtonEnableTest()
	{
		boolean buttonMode = driver.findElement(By.id("calculate_data")).isEnabled();
		boolean ButtonShow = driver.findElement(By.id("calculate_data")).isDisplayed();
		
		assertTrue("The button is not enabled!!",buttonMode);
		assertTrue("The button not shows!!",ButtonShow);
	}
	
	@Test
	public void ButtonTag()
	{
		String ButtonTag = driver.findElement(By.id("calculate_data")).getTagName();
		String ButtonTxt = driver.findElement(By.id("calculate_data")).getAttribute("value");
		
		assertEquals("Button tag value is not input.","input",ButtonTag);
		assertEquals("Button text is not as expected 'Calculate BMI'.","Calculate BMI",ButtonTxt);
	}
}
