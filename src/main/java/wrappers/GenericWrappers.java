package wrappers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.codehaus.plexus.util.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utils.Reporter;

public class GenericWrappers extends Reporter implements Wrappers {

	public GenericWrappers(RemoteWebDriver driver, ExtentTest test){
		this.driver=driver;
		this.test=test;
	}

	public RemoteWebDriver driver;
	public String sURL, sHost, sPort, sBrowser;

	public GenericWrappers() {
		Properties prop = new Properties();
		try{
			prop.load(new FileInputStream(new File("./src/main/resources/config.properties")));
			sHost=prop.getProperty("Host");
			sPort=prop.getProperty("Port");
			sURL = prop.getProperty("URL");
			sBrowser=prop.getProperty("browser");
		}
		catch (FileNotFoundException e){
			e.printStackTrace();
		}
		catch (IOException e){
			e.printStackTrace();
		}
	}
	
	public void enterText(By locator, String text){
		driver.findElement(locator).clear();
		driver.findElement(locator).sendKeys(text);
		reportStep("Pass", "Text Entered");
	}

	public void clickButton(By locator) {
		// TODO Auto-generated method stub
		driver.findElement(locator).click();
		reportStep("pass", "Login button clicked");
	}
	
	@Override
	public void invokeApp(String browser){
		switch(browser){
		case "chrome":
			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			driver=new ChromeDriver();
			break;
		case "edge":
			System.setProperty("webdriver.edge.driver", "./drivers/MicrosoftWebDriver.exe");
			driver=new EdgeDriver();
			break;
		}
		driver.get(sURL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Override
	public void closeApp() {
		// TODO Auto-generated method stub
		driver.close();
	}

	@Override
	public long takeSnap() {
		// TODO Auto-generated method stub
		long snapNumber=(long) Math.floor(Math.random() * 900000000L) + 10000000L;
		File src = driver.getScreenshotAs(OutputType.FILE);
		File dest = new File("./reports/snaps/"+snapNumber+".jpg");
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return snapNumber;
	}
}
