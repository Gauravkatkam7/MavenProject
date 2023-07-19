package PB_Module2_LoginTest1;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Library1.BaseClass;
import Library1.UtilityClass;
import PB_Module2_Login.PBHomePage;
import PB_Module2_Login.PBLoginPage;
import PB_Module2_Login.PBMobNumPage;
import PB_Module2_Login.PBMyAccPage;
import PB_Module2_Login.PBPolicyPage;
import PB_Module2_Login.PBProfilePage;
import PB_Module2_Login.PBPwdPage;
import PB_Module2_Login.PBTermInsurancePage;

public class PBLoginTest extends BaseClass
{
	PBLoginPage login;
	PBMobNumPage mobnum;
	PBPwdPage pwd;
	PBHomePage home;
	PBMyAccPage myacc;
	PBProfilePage profile;
	PBPolicyPage policy;
	PBTermInsurancePage term;

	int TCID;
	@BeforeClass
	public void openBrowser() throws IOException
	{
		initializeBrowser();
		
		login=new PBLoginPage(driver);
		mobnum=new PBMobNumPage(driver);
		pwd=new PBPwdPage(driver);
		home=new PBHomePage(driver);
		myacc=new PBMyAccPage(driver);
		profile=new PBProfilePage(driver);
		policy=new PBPolicyPage(driver);
		term=new PBTermInsurancePage(driver);
	}
	
	@BeforeMethod
	public void signInToApp() throws IOException, InterruptedException
	{
		login.clickPBLoginPageSignInBtn();
		mobnum.inpPBMobNumPageMobNum(UtilityClass.getPFData("MobNum"));
		mobnum.clickPBMobNumPageSignInWithPwdBtn();
		pwd.inpPBPwdPagePwd(UtilityClass.getPFData("Pwd"));
		pwd.clickPBPwdPageSignIn();
		Thread.sleep(2000);
	}
	
	@Test(priority=1)
	public void verifyFullName() throws EncryptedDocumentException, IOException, InterruptedException
	{
		TCID=101;
		Thread.sleep(2000);
		UtilityClass.openDDOptions(driver, home.getPBHomePagemyAcc());
		myacc.clickPBMyAccPageMyProfileBtn();
		UtilityClass.switchToBrowser(driver, 1);
		
		SoftAssert soft=new SoftAssert();
		
		String actualName = profile.getPBProfilePageFullName();
		String expName=UtilityClass.getTestData(0, 2);
		
		String actEmail = profile.getPBProfilePageEmail();
		String expEmail=UtilityClass.getTestData(0, 3);
		
		soft.assertEquals(actualName, expName,"Failed:Both Results Are Not Same");
		Reporter.log("Both Results Are Same",true);
	
		soft.assertEquals(actEmail,expEmail,"Failed:Both REsults Are Not same");
		Reporter.log("Both Results Are Same",true);
	
		Thread.sleep(2000);
		
		soft.assertAll();
	}
	
	@Test(priority=2)
	public void verifyPolicy() throws EncryptedDocumentException, IOException, InterruptedException
	{
		TCID=102;
		UtilityClass.openDDOptions(driver, home.getPBHomePagemyAcc());
		myacc.clickPBMyAccPageMyPoliciesBtn();
		
		UtilityClass.switchToBrowser(driver, 2);
		Thread.sleep(2000);
		String actualText = policy.getPBPolicyPageYourPolicies();
		String expText=UtilityClass.getTestData(0, 4);
		
		assertEquals(actualText, expText,"Failed:Both REsults Are Not same");
		Reporter.log("Both Results Are Same",true);
		
	}
	@Test(priority=3)
	public void verifyTermInsurance() throws InterruptedException, IOException
	{
		TCID=103;
		Thread.sleep(2000);
		home.clickPBHomePageTermInsurance();
		boolean value = term.getPBTermInsurancePageImg();
		Assert.assertTrue(value, "failed:element is not displaying");
		Reporter.log("element is displaying",true);
		Thread.sleep(2000);
		driver.navigate().to(UtilityClass.getPFData("URL"));
	}
	
	@AfterMethod
	public void VerifyTestCases(ITestResult s1) throws IOException
	{
		if(s1.getStatus()==ITestResult.FAILURE)
		{
			UtilityClass.captureSS(driver, TCID);
		}	
	}
	
	@AfterMethod
	public void signOutFromApp() throws InterruptedException
	{
		UtilityClass.switchToBrowser(driver, 0);
		UtilityClass.openDDOptions(driver, home.getPBHomePagemyAcc());
		myacc.clickPBMyAccPageSignOut();
		Thread.sleep(2000);
		
		
	}
	@AfterClass
	public void closeBrowser() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.quit();
	}
}
