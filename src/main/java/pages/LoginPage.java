package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.LeafTapsWrappers;

public class LoginPage extends LeafTapsWrappers {

	public LoginPage(RemoteWebDriver driver, ExtentTest test){		
		this.driver=driver;
		this.test=test;
	}
	
	By username = By.id("username");
	By password = By.id("password");
	By loginButtton = By.className("decorativeSubmit");
	
	public LoginPage enterUsername(){
		enterText(username, "DemoSalesManager");
		return this;
	}
	
	public LoginPage enterPassword(){
		enterText(password, "crmsfa");
		return this;
	}
	
	public HomePage clickLoginButton(){
		clickButton(loginButtton);
		return new HomePage(driver,test);
	}
	
}
