package PB_Mudule1_LoginTest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Library.BaseClass;
import Library.UtilityClass;
import PB_Module1_Login.PBHomePage;
import PB_Module1_Login.PBLoginPage;
import PB_Module1_Login.PBMobNumPage;
import PB_Module1_Login.PBMyAccPage;
import PB_Module1_Login.PBProfilePage;
import PB_Module1_Login.PBPwdPage;

public class PBLoginTest extends BaseClass
{

	PBLoginPage login;
	PBMobNumPage mobnum;
	PBPwdPage pwd;
	PBHomePage home;
	PBMyAccPage myacc;
	PBProfilePage profile;
	
	int TCID;
	
	@Parameters("browserName")
	@BeforeClass
	public void openBrowser(String browserName) throws IOException
	{
		initializeBrowser(browserName);
		
		login=new PBLoginPage(driver);
		mobnum=new PBMobNumPage(driver);
		pwd=new PBPwdPage(driver);
		home=new PBHomePage(driver);
		myacc=new PBMyAccPage(driver);
		profile=new PBProfilePage(driver);
	}
	
	@BeforeMethod
	public void signInToApp() throws IOException, InterruptedException
	{
		login.clickPBLoginPagesignIn();
		mobnum.inpPBMobNumPagemobNum(UtilityClass.getPFData("MobNum"));
		mobnum.clickPBMobNumPageSignInBtn();
		pwd.inpPBPwdPagePwd(UtilityClass.getPFData("Pwd"));
		pwd.clickPBPwdPageSignIn();
		Thread.sleep(2000);
		
	}
	
	@Test
	public void verifyFullName() throws EncryptedDocumentException, IOException, InterruptedException
	{
		TCID=102;
		
		home.openDDOptionsPBHomePagemyAcc();
		Thread.sleep(2000);
		myacc.clickPBMyAccPagemyProfile();
		profile.switchToChildBrowser();
		String actualResult = profile.getActualResult();
		String expectedResult= UtilityClass.gatTestData(0, 2);
		Assert.assertEquals(actualResult, expectedResult,"Failed:both result are not same");
		Thread.sleep(2000);
	}
	
	@AfterMethod
	public void logOutFromApp(ITestResult s1) throws IOException
	{
		if(s1.getStatus()==ITestResult.FAILURE)
		{
			UtilityClass.captureSS(driver, TCID);
		}
	}
	
	@AfterClass
	public void closeBrowser() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.quit();
		
	}
	
}
