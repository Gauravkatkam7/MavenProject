package Library1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;

public class UtilityClass {

	public static String getTestData(int rowNum,int cellNum) throws EncryptedDocumentException, IOException
	{
		FileInputStream file=new FileInputStream("C:\\Users\\Gaurav\\eclipse-workspace\\MavenProject\\TestData\\samplestring.xlsx");
		
		Sheet sh = WorkbookFactory.create(file).getSheet("Sheet1");
		
		String data = sh.getRow(rowNum).getCell(cellNum).getStringCellValue();
		return data;
	}
	
	public static void captureSS(WebDriver driver,int TCID) throws IOException
	{
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		File dest=new File("C:\\Users\\Gaurav\\eclipse-workspace\\MavenProject\\FailedTCesSS\\TestCase"+TCID+".jpg");
		
		FileHandler.copy(src, dest);
	}
	
	public static void switchToBrowser(WebDriver driver,int index)
	{
		Set<String> allid = driver.getWindowHandles();
		ArrayList<String>ar=new ArrayList<String>(allid);
		driver.switchTo().window(ar.get(index));
	}
	
	public static String getPFData(String key) throws IOException
	{
		FileInputStream file=new FileInputStream("C:\\Users\\Gaurav\\eclipse-workspace\\MavenProject\\PropertyFile1.properties");
		Properties p=new Properties();
		p.load(file);
		String value = p.getProperty(key);
		
		return value;
	}
	public static void openDDOptions(WebDriver driver,WebElement ele)
	{
		Actions act=new Actions(driver);
		act.moveToElement(ele).perform();;
	}
}
