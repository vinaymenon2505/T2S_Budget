package pageObjects;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import resources.base;

public class DatePicker extends base
{
	public void selectDate(WebElement calendar, String year, String monthName, String day, WebDriver driver) throws ParseException
	{
		//Clicking on calendar to open calendar widget
		driver.findElement(By.xpath("//*[@id=\"from\"]")).click();
		
		// Retrieving current year value
		String currentYear= driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div[1]/div")).getText();
	
		// Click on Next arrow till we get desired year
		if(!currentYear.equals(year))
		{
			do
			{
				driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div[3]/div/a")).click();
			}
			while(!driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div[1]/div")).getText().equals(year));				
		}
		
		// Select desired month after selecting desired year
		
		String currentMonth= driver.findElement(By.xpath("(//*[@id=\\\"ui-datepicker-div\\\"]/div[2]/div/div/span[1]")).getText();
		if(!currentMonth.equalsIgnoreCase(monthName))
		{
			do
			{
				driver.findElement(By.xpath("(//*[@id=\\\"ui-datepicker-div\\\"]/div[2]/div/div/span[1]")).click();
			}
			while(!driver.findElement(By.xpath("(//*[@id=\\\"ui-datepicker-div\\\"]/div[2]/div/div/span[1]")).getText().trim().equalsIgnoreCase(monthName));
			
		}
		//get java month number for desired month
		
		int javaMonthInt= DatePicker.getMonthJavaInt(monthName);
		
		// Find dates of desired month only
		
		List<WebElement> allDateOfDesiredMonth= driver.findElements(By.xpath("//*[@id=\\\"ui-datepicker-div\\\"]/div[2]/div/div/span[1'"+javaMonthInt+"']"));
		for(WebElement d:allDateOfDesiredMonth )
		{
			if(d.getText().trim().equals(day))
			{
				d.click();
				break;
			}
		}			
		
	}
	
	// Code to get java month number
	public static int getMonthJavaInt(String monthName) throws ParseException 
	{
	
		Date date = new SimpleDateFormat("MMMM").parse(monthName);
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(Calendar.MONTH);
	}

	static String today = getCurrentDay();	
	public  void dateafter7days()
	{
		//Get Today's date
        
        System.out.println("Today's date: " + today + "\n");
        
		WebElement dateWidget = driver.findElement(By.cssSelector("#from"));
		List<WebElement> columns=dateWidget.findElements(By.tagName("td"));

		for (WebElement cell: columns)
		{
		   //Select 7th Date 
		   if (cell.getText().equals("14"))
		   {
		      cell.findElement(By.linkText("14")).click();
		      break;
		   }
		}
	}
	
	public  void dateafter14days()
	{			   
		WebElement dateWidget1 = driver.findElement(By.cssSelector("#to"));
		List<WebElement> columns1=dateWidget1.findElements(By.tagName("td"));

		for (WebElement cell: columns1)
		{
			   //Select 14th Date 
			   if (cell.getText().equals("21"))
			   {
			      cell.findElement(By.linkText("21")).click();
			      break;
			   }
		}
	}
	
	private static String getCurrentDay ()
    {
        //Create a Calendar Object
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
 
        //Get Current Day as a number
        int todayInt = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println("Today Int: " + todayInt +"\n");
 
        //Integer to String Conversion
        String todayStr = Integer.toString(todayInt);
        System.out.println("Today Str: " + todayStr + "\n");
 
        return todayStr;
    }
}