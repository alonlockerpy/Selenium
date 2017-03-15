import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverService;


public class Class_Lesson_6 
{
	@Test
	public void T2()
	{
		System.out.println("this is @Test2");
	}
	
	@Test
	public void T()
	{
		System.setProperty("webdriver.chrome.driver", "/home/alonlocker/Drivers/chromedriver");
		WebDriver CHdriver = new ChromeDriver();
		CHdriver.get("https://translate.google.co.il");
		System.out.println("this is @Test will load Chrome browser");
	}
	
	@Test
	public void T1()
	{
		System.setProperty("webdriver.gecko.driver", "/home/alonlocker/Drivers/geckodriver");
		WebDriver FFdriver = new FirefoxDriver();
		FFdriver.get("http://stackoverflow.com/");
		System.out.println("this is @Test1 will load FireFox browser");
	}
	
	@Before
	public void B()
	{
		System.out.println("this is @Before");
	}
	
	@After
	public void A()
	{
		System.out.println("this is @After");
	}
	
	@BeforeClass
	public static void BC()
	{
		
		System.out.println("this is @BeforeClass");
	}
	
	@AfterClass
	public static void AC()
	{
		System.out.println("this is @AfterClass");
	}

}
