package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import resources.base;

public class SelectCar extends base
{
		public void selectCar()
	{
	    WebElement selectcar = driver.findElement(By.xpath("//*[@id=\"res-home-select-car\"]"));
	    selectcar.submit();	    
	}

}
