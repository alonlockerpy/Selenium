//import org.junit.After;
import org.junit.AfterClass;
//import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.firefox.GeckoDriverService;


public class Class_Lesson_6 
{
	public static WebDriver driver;
	public String SiteTitleExpected = "IMDb - Movies, TV and Celebrities - IMDb";
	public String SiteUrlExpected = "http://www.imdb.com/";
	public String siteTitle;
	public String siteUrl;
	
	@BeforeClass
	public static void BC()
	{
		//System.setProperty("webdriver.gecko.driver", "/home/alonlocker/Drivers/geckodriver");
		//driver = new FirefoxDriver();
		System.setProperty("webdriver.chrome.driver", "/home/alonlocker/Drivers/chromedriver");
		driver = new ChromeDriver();
	}
	
	//@Before
	//public void B()
	//{
	//	System.out.println("this is @Before");
	//}
	
	@Test
	public void T1()
	{
		driver.get("http://www.imdb.com/");
		System.out.println("Open CH with imdb site");
		
		driver.navigate().refresh();
		System.out.println("Refresh imdb site");
		
		siteTitle = driver.getTitle();
		if(siteTitle.equals(SiteTitleExpected))
		{
			System.out.println("the site title as expected");
		}
		else
		{
			System.out.println("Please check site title!");
		}
		
		siteUrl = driver.getCurrentUrl();
		if(siteUrl.equals(SiteUrlExpected))
		{
			System.out.println("the site url as expected");
		}
		else
		{
			System.out.println("Please check site url!");
		}
		
	}

	//@Test
	//public void T2()
	//{
		//FFdriver.get("http://stackoverflow.com/");
		//System.out.println("this is @Test1 will load FireFox browser");
	//}
	
	//@After
	//public void A()
	//{
	//	System.out.println("this is @After");
	//}
	
	
	
	@AfterClass
	public static void AC()
	{
		System.out.println("this is @AfterClass");
	}

}
