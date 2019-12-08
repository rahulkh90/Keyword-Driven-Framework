package com.rk.yt.TestCases;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.rk.yt.pages.LoginPage;
import com.rk.yt.pages.TestBase;
import com.rk.yt.utilities.Helper;

public class LoginPageTest extends TestBase {

	
	//public static HomePage hp = new HomePage();
	public static LoginPage lp;

	@Test(dataProvider = "data", dataProviderClass = Helper.class)
	public void verify(String uname, String password) {
		logger=report.createTest("Login Test");
		lp = new LoginPage(driver);
		logger.info("Application Launched");
		//sa.assertTrue(false);
		lp.login(uname, password);
		Reporter.log("Login Done Successfully");
		lo.takeLog("verify", "All done ");
		//Assert.assertEquals(hp.profileDet(), "rahul.khurana1990@gmail.com");
		//sa.assertAll();
		
	}

}
