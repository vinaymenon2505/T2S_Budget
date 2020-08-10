package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SUVFilter
{
	public static WebDriver driver;
	public static void clickTab(String tabText)
	{
		  List<WebElement> tabs = driver.findElements(By.className("tab-strip-text"));      
		    for(WebElement tab : tabs){
		        if(tab.getText().equals(tabText)){
		            tab.click();
		            break;
		        }
		    }       
		}

}
