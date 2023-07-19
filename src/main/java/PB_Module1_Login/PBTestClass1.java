package PB_Module1_Login;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Library.BaseClass1;
import Library.UtilityClass1;

public class PBTestClass1 extends BaseClass1
{

	PBLoginPage1 login;
	PBMobNumPage1 mobnum;
	PBPwdPage1 pwd;
	PBHomePage1 home;
	PBMyAccPage1 myacc;
	PBProfilePage1 profile;
	PBPolicyPage1 policy;
	
	int TCID;
	
	@BeforeClass
	public void openBrowser()
	{
		initializeBrowser();
		
		login=new PBLoginPage1(driver);
		mobnum=new PBMobNumPage1(driver);
		pwd=new PBPwdPage1(driver);
		home=new PBHomePage1(driver);
		myacc=new PBMyAccPage1(driver);
		profile=new PBProfilePage1(driver);
		policy =new PBPolicyPage1(driver);
		
	}
	
	@BeforeMethod
	public void signInToApp() throws IOException
	{
		login.clickPBLoginPage1SignIn();
		mobnum.inpPBMobNumPage1mobNum(UtilityClass1.getPFData("MobNum"));
		mobnum.clickPBMobNumPage1SignInWithPwd();
		pwd.inpPBPwdPage1Pwd(UtilityClass1.getPFData("Pwd"));
		pwd.clickPBPwdPage1SignInbtn();
	}
	
	@Test
	public void verifyFullName() throws EncryptedDocumentException, IOException
	{
		TCID=101;
		home.openDDOptionsPBHomePage1myAcc();
		myacc.clickPBMyAccPage1myProfile();
		UtilityClass1.switchToWindow(driver, 1);
		
		SoftAssert soft=new SoftAssert();
		
		String actualResult = profile.getActualName();
		String expectedResult =UtilityClass1.getTestData(0, 2);
		
		String actualResult1 = profile.getActualEmail();
		String expectedResult1=UtilityClass1.getTestData(0, 3);
		soft.assertEquals(actualResult, expectedResult,"Failed:Both Results are not same");
		soft.assertEquals(actualResult1, expectedResult1,"Failed:both Rsults are not same");
		
		soft.assertAll();
	}
	
	@Test
	public void verifyText() throws EncryptedDocumentException, IOException
	{
		TCID=102;
		UtilityClass1.switchToWindow(driver, 0);
		home.openDDOptionsPBHomePage1myAcc();
		policy.clickPBPolicyPage1MyPolicies();
		String actualResult = policy.getTextPBPolicyPage1YourPolicies();
		String expectedResult= UtilityClass1.getTestData(0, 4);
		Assert.assertEquals(actualResult, expectedResult,"Failed:both results are not same");
	}
	
	@AfterMethod
	public void logOutFromApp(ITestResult s1) throws IOException
	{
		if(s1.getStatus()==ITestResult.FAILURE)
		{
			UtilityClass1.capureSS(driver, TCID);
		}
	}
	@AfterClass
	public void closeBrowser() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.quit();
	}
}
