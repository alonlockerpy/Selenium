import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import javax.swing.JOptionPane;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;


public class Selenium_Lesson_BMI
{
	public static String getData(String nodeName) throws ParserConfigurationException, SAXException, IOException
	{
	File fXmlFile = new File("/home/alonlocker/workspace/SEleniumCourse1/src/Enviroment.xml");
	DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	Document doc = dBuilder.parse(fXmlFile); 
	doc.getDocumentElement().normalize();
	return doc.getElementsByTagName(nodeName).item(0).getTextContent();
	}
	
	public static WebDriver driver;
	
	@BeforeClass
	public static void BC()
	{
		System.setProperty("webdriver.chrome.driver", "/home/alonlocker/Drivers/chromedriver");
		driver = new ChromeDriver();
	}
	
	@Test
	public void BMICalculateTest() throws ParserConfigurationException, SAXException, IOException
	{
		driver.get(getData("Url"));
		System.out.println("Open BMI page");
		
		driver.findElement(By.id("weight")).sendKeys(getData("PersonWeight"));
		driver.findElement(By.id("hight")).sendKeys(getData("PersonHight"));
		driver.findElement(By.id("calculate_data")).click();
		
		String BMI = driver.findElement(By.id("bmi_result")).getAttribute("value");
		assertEquals("The found BMI is not as expected!","25",BMI);
	}
	
	
	@Test
	public void ButtonSizeLocationTest() throws ParserConfigurationException, SAXException, IOException
	{
		try
		{
		int buttonWidth = driver.findElement(By.id("calculate_data")).getSize().getWidth();
		int buttonHight = driver.findElement(By.id("calculate_data")).getSize().getHeight();
		int buttonLocationX = driver.findElement(By.id("calculate_data")).getLocation().getX();
		int buttonLocationY = driver.findElement(By.id("calculate_data")).getLocation().getY();
		
		System.out.println("Button size: " + buttonWidth + "X" + buttonHight);
		System.out.println("Button location: " + buttonLocationX + "X" + buttonLocationY);
		assertEquals("The button width size is not much!",getData("buttonWidth"),buttonWidth);
		assertEquals("The button hight size is not much!",35,buttonHight);
		}
		catch (AssertionError ae) {
			System.out.println("Assertion button size fail: " + ae);
		}
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
	
	@Test
	public void ValidationTest()
	{
		Boolean ValidationTxt = false;
		try
		{
			ValidationTxt = driver.findElement(By.id("validation")).isDisplayed();
			assertTrue("Validarion text not found", ValidationTxt);
		}
		
		catch (Exception e) 
		{
			JOptionPane.showMessageDialog(null, "Validation text not seen");
		}
		
	}
	
	@AfterClass
	public static void close()
	{
		driver.close();
	}
}
