package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.LeafTapsWrappers;

public class HomePage extends LeafTapsWrappers{
	
	public HomePage(RemoteWebDriver driver, ExtentTest test){
		this.driver=driver;
		this.test=test;
	}

}
