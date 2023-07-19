package Library;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;

public class UtilityClass1 {

	public static String getTestData(int rowIndex,int collIndex) throws EncryptedDocumentException, IOException
	{
		FileInputStream file=new FileInputStream("C:\\Users\\Gaurav\\eclipse-workspace\\MavenProject\\TestData\\samplestring.xlsx");
		Sheet sh = WorkbookFactory.create(file).getSheet("Sheet1");
		String value = sh.getRow(rowIndex).getCell(collIndex).getStringCellValue();
		
		return value;
	}
	
	public static void capureSS(WebDriver driver,int TCID) throws IOException
	{
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		File dest=new File("C:\\Users\\Gaurav\\eclipse-workspace\\MavenProject\\FailedTCesSS\\TestCaseId"+TCID+".jpg"); 
		FileHandler.copy(src, dest);
	}
	
	public static String getPFData(String key) throws IOException
	{
		FileInputStream file=new FileInputStream("C:\\Users\\Gaurav\\eclipse-workspace\\MavenProject\\PropertyFile.properties");
		Properties p=new Properties();
		p.load(file);
		String value = p.getProperty(key);
		 
		 return value;
	}
	
	public static void switchToWindow(WebDriver driver,int index)
	{
		Set<String> allids = driver.getWindowHandles();
		ArrayList<String>ar=new ArrayList<String>(allids);
		driver.switchTo().window(ar.get(index));
	}
	
//	public static void openDDOptionsPBHomePage1MyAcc(WebDriver driver,String xpath)
//	{
//		WebElement element = driver.findElement(By.xpath(xpath));
//		Actions act=new Actions(driver);
//		act.moveToElement(element).perform();
//	}
	
	public static void openDDOptionsPBHomePage1MyAcc(WebDriver driver,WebElement ele)
	{
		
		Actions act=new Actions(driver);
		act.moveToElement(ele).perform();
	}
	

	
}
