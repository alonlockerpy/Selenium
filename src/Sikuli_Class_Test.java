import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;

public class Sikuli_Class_Test
{
	public static WebDriver driver;

	@BeforeClass
	public static void BC()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.get("https://www.google.co.il/maps/@32.0666386,34.7796028,15z?hl=iw");
		System.out.println("Open timeout test page");
	}
	
	@Test
	public void mapTest() throws InterruptedException, FindFailed 
	{
		Thread.sleep(5000);
		driver.findElement(By.id("searchboxinput")).sendKeys("sarona");
		
		Screen screen = new Screen();
		screen.find("C:\\selenium\\img\\search.PNG");
		screen.click("C:\\selenium\\img\\search.PNG");
		screen.find("C:\\selenium\\img\\market.PNG");
		screen.click("C:\\selenium\\img\\minus.PNG");
	}
	

	@AfterClass
	public static void AC()
	{
		//driver.quit();
		//System.out.println("Close CH browser");
	}

}
