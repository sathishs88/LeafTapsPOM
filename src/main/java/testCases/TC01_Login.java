package testCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.LoginPage;
import wrappers.LeafTapsWrappers;

public class TC01_Login extends LeafTapsWrappers{
	
	@BeforeClass
	public void setData() {
		testName="Login";
		//testDescription="Login To Opentaps";
		//browserName="chrome";
		//dataSheetName="TC001";
		category="Smoke";
		authors="Sathish";
	}

	
	@Test
	public void loginTest(){
		new LoginPage(driver, test)
		.enterUsername()
		.enterPassword()
		.clickLoginButton();
	}

}
