package wrappers;

import org.openqa.selenium.By;

public interface Wrappers {
	
	public void enterText(By locator, String Text);
	public void clickButton(By locator);
	public void invokeApp(String browser);
	public void closeApp();
}
