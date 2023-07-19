package FK_Module1_Login;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Library.BaseClass3;

public class FKTestClass extends BaseClass3 {

	FKhiddenDivisionPopupPage hidden;
	FKHomePage home;
	FKElectronicsPage electronics;
	
	@BeforeClass
	
	public void openBrowser()
	{
		initializeBrowser();
		hidden=new FKhiddenDivisionPopupPage(driver);
		home=new FKHomePage(driver);
		electronics=new FKElectronicsPage(driver);
	}
	@BeforeMethod
	
	public void closePopup() throws InterruptedException
	{
		hidden.clickFKhiddenDivisionPopupPageCloseBtn();
		Thread.sleep(5000);
	}
	
	@Test
	public void clickOnGaming() throws InterruptedException
	{
		home.openDDOptionsFKHomePageelectronics();
		Thread.sleep(2000);
		electronics.clickFKElectronicsPageGaming();
		
	}
	
	@AfterMethod
	public void sos()
	{
		
	}
	@AfterClass
	public void closeBrowser() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.close();
	}
}
