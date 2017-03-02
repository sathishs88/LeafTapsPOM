package utils;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public abstract class Reporter {
	
	public ExtentReports report;
	public ExtentTest test;
	public String testName, category, authors;
	
	public abstract long takeSnap();
	
	public ExtentReports startReport(){
		report=new ExtentReports("./reports/result.html", false);
		return report;
	}
	
	public ExtentTest startTestcase(String testName){
		test=report.startTest(testName);
		return test;
	}
	
	public void endTestcase(){
		report.endTest(test);
	}
	
	public void endReport(){
		report.flush();
	}
	
	public void reportStep(String status, String desc){
		long snapNumber = takeSnap();
		String imagePath = "./../reports/snaps/"+snapNumber+".jpg";
		if(status.toLowerCase().equals("pass")){
			test.log(LogStatus.PASS, desc+test.addScreenCapture(imagePath));
		}
		else if(status.toLowerCase().equals("fail")){
			test.log(LogStatus.FAIL, desc+test.addScreenCapture(imagePath));
			throw new RuntimeException("Failed");
		}
		else if(status.toLowerCase().equals("info")){
			test.log(LogStatus.INFO, desc);
		}
	}

}
