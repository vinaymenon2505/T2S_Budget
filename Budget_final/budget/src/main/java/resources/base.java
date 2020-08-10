package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class base 
{

	public static  WebDriver driver;
	public Properties prop;
	public WebDriver initializeDriver() throws IOException
	{
		
			prop= new Properties();
			FileInputStream fis=new FileInputStream("D:\\Vinay\\budget\\src\\main\\java\\resources\\data.properties");
			prop.load(fis);
			String browserName=prop.getProperty("browser");
			System.out.println(browserName);
	
			if(browserName.equals("chrome"))
			{
				//Execute in chrome browser
				
				System.setProperty("webdriver.chrome.driver", "D:\\Vinay\\chromedriver.exe");
				driver= new ChromeDriver();
					
				
			}
			else if (browserName.equals("firefox"))
			{
				//Execute in Firefox browser
				
				System.setProperty("webdriver.gecko.driver", "D:\\Vinay\\geckodriver.exe");			
				driver= new FirefoxDriver();			
			}
			else if (browserName.equals("IE"))
			{
				//Execute in IE browser
				
				System.setProperty("webdriver.ie.driver", "D:\\Vinay\\IEDriverServer.exe");			
				driver=new InternetExplorerDriver();
			}
			
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			return driver;
	}

	public String getScreenShotPath(String testCaseName,WebDriver driver) throws IOException
		{
			TakesScreenshot ts=(TakesScreenshot) driver;
			File source =ts.getScreenshotAs(OutputType.FILE);
			String destinationFile = System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
			FileUtils.copyFile(source,new File(destinationFile));
			return destinationFile;
		}

}
