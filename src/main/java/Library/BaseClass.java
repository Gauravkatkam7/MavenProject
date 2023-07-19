package Library;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass {

	public WebDriver driver;
	
	public void initializeBrowser(String browserName) throws IOException
	{
		
		if(browserName.equals("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(browserName.equals("firefox"))
		{
			driver=new FirefoxDriver();
		}
		else if(browserName.equals("edge"))
		{
			driver=new EdgeDriver();
		}
		
		driver.get(UtilityClass.getPFData("URL"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
}
