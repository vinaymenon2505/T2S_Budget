package budget.budget;

import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
//import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

//import pageObjects.LandingPage;
import resources.base;

public class Homepage extends base
{

	public WebDriver driver;	
	public static Logger log =LogManager.getLogger(base.class.getName());
	
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
	
	/*@Test
	public void verifytitle()
	{
		LandingPage lp = new LandingPage(driver);
		lp.getTitle();
	}
	
	/*@AfterTest
	public void teardown()
	{		
		driver.close();		
	}*/
	
	/*@DataProvider
	public Object[][] getData()
	{
		
	}*/
}