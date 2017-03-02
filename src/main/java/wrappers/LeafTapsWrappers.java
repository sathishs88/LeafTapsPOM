package wrappers;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class LeafTapsWrappers extends GenericWrappers {
	
	@BeforeSuite
	public void beforeSuite(){
		startReport();
	}
	
	@BeforeMethod
	public void beforeMethod(){
		test = startTestcase(testName);
		test.assignAuthor(authors);
		test.assignCategory(category);
		invokeApp(sBrowser);
	}
	
	@AfterMethod
	public void afterMethod(){
		endTestcase();
		closeApp();
	}
	
	@AfterSuite
	public void afterSuite(){
		endReport();
	}

}
