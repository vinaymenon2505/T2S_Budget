package budget.budget;

import java.io.IOException;
import java.text.ParseException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.AfterTest;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.DatePicker;
import pageObjects.LandingPage;
import pageObjects.SelectCar;
import resources.base;

public class AppTest extends base
{
	public WebElement calendar;
	public String year;
	public String monthName;
	public String day;
	public WebDriver driver;
	
	@BeforeTest
	public void initialize() throws IOException
	{	
		 driver =initializeDriver();
	}
	
	@Test	
	public void basePageNavigation() throws IOException
	{
		driver.get(prop.getProperty("url"));		
	}	
	
	@Test
	public void basicstep() throws InterruptedException, ParseException
	{
		LandingPage lp = new LandingPage();
		lp.FirstPage(driver);		
		lp.pickuplocation();	
		
		
		WebElement departCal= driver.findElement(By.xpath("//*[@id=\"to\"]"));
		DatePicker dp =new DatePicker();
		dp.selectDate(departCal, "2020", "August", "06", driver);
		dp.dateafter7days();
		dp.dateafter14days();
		SelectCar sc = new SelectCar();
		sc.selectCar();
	}
}


	
	
	
	/*@AfterClass
	public void teardown()
	{		
		driver.close();		
	}*/

