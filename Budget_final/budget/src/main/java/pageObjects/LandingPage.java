package pageObjects;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage 
{
	public WebDriver driver;
	public WebElement element;
	public Properties prop;
	public String today;
	public WebElement option;
			
	public void FirstPage(WebDriver driver) 
	{
		this.driver=driver;
	}
	
	public void pickuplocation() throws InterruptedException 
	{	 
		//WebDriverWait wait1 = new WebDriverWait(driver, 15);
		//wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("PicLoc_value")));
			
		System.out.println("Select pick up location");
		WebElement dropdown = driver.findElement(By.cssSelector("#PicLoc_value"));
		dropdown.sendKeys("Austin Bergstrom Intl Airport, Austin, Texas");
		
		option = driver.findElement(By.xpath("//*[@id=\"PicLoc_dropdown\"]/div[3]/div[1]/div[2]/div/div"));
		//Thread.sleep(5000);
		for(int i=0;i<2;i++)
		{
			try
			{		 
				option.click();	
				
			}
			catch(Exception e)
			{			 
			System.out.println(e.getMessage());			 
			}		
		}		
	}
}
